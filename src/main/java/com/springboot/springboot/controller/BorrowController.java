package com.springboot.springboot.controller;

import com.springboot.springboot.Repository.BookRepository;
import com.springboot.springboot.Repository.BorrowRepository;
import com.springboot.springboot.Repository.UserRepository;
import com.springboot.springboot.exception.ResourceNotFoundException;
import com.springboot.springboot.model.Book;
import com.springboot.springboot.model.Books_Out_On_Loan;
import com.springboot.springboot.model.PK_BooksOutOnLoan;
import com.springboot.springboot.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/Borrowing")
public class BorrowController {

    @Autowired
    private BorrowRepository borrowRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BookRepository bookRepository;

    @GetMapping
    public List<Books_Out_On_Loan> findAll()
    {
        return borrowRepository.findAll();
    }

    @PostMapping(value = "/{user_id}/{book_id}")
    public Books_Out_On_Loan creatBorrow(@PathVariable long user_id,@PathVariable long book_id)//,@RequestBody Books_Out_On_Loan books_out_on_loan)
    {
        User user=userRepository.findById(user_id).orElseThrow(()-> new ResourceNotFoundException("User not exist in id: "+user_id));
        Book book=bookRepository.findById(book_id).orElseThrow(()-> new ResourceNotFoundException("Book not exist in id: "+book_id));
        Books_Out_On_Loan books_out_on_loan = new Books_Out_On_Loan(user,book);
        return borrowRepository.save(books_out_on_loan);
    }

    @GetMapping("/{user_id}/{book_id}")
    public ResponseEntity<Books_Out_On_Loan> getBooks_Out_On_LoanByID(@PathVariable long user_id,@PathVariable long book_id)
    {
        User user=userRepository.findById(user_id).orElseThrow(()->new ResourceNotFoundException("User not exist in id: "+user_id));
        Book book=bookRepository.findById(book_id).orElseThrow(()->new ResourceNotFoundException("Book not exist in id: "+book_id));
        Books_Out_On_Loan books_out_on_loan=borrowRepository.findByUserAndBook(user,book);
        return ResponseEntity.ok(books_out_on_loan);
    }

    @PutMapping("/{user_id}/{book_id}")
    public ResponseEntity<Books_Out_On_Loan> updateAuthor(@PathVariable long user_id,@PathVariable long book_id,@RequestBody Books_Out_On_Loan books_out_on_loan)
    {
        User user=userRepository.findById(user_id).orElseThrow(()->new ResourceNotFoundException("User not exist in id: "+user_id));
        Book book=bookRepository.findById(book_id).orElseThrow(()->new ResourceNotFoundException("Book not exist in id: "+book_id));
        Books_Out_On_Loan updated = borrowRepository.findByUserAndBook(user,book);

        updated.setDate_Issued(books_out_on_loan.getDate_Issued());
        updated.setDate_due_for_return(books_out_on_loan.getDate_due_for_return());
        updated.setDate_returned(books_out_on_loan.getDate_returned());
        updated.setAmount_of_fine(books_out_on_loan.getAmount_of_fine());

        borrowRepository.save(updated);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{user_id}/{book_id}")
    public ResponseEntity<Books_Out_On_Loan> deleteBooks_Out_on_Loan(@PathVariable long user_id,@PathVariable long book_id)
    {
        User user=userRepository.findById(user_id).orElseThrow(()->new ResourceNotFoundException("User not exist in id: "+user_id));
        Book book=bookRepository.findById(book_id).orElseThrow(()->new ResourceNotFoundException("Book not exist in id: "+book_id));
        Books_Out_On_Loan books_out_on_loan = borrowRepository.findByUserAndBook(user,book);
        borrowRepository.delete(books_out_on_loan);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}