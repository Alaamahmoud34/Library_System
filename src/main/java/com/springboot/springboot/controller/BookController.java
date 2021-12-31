package com.springboot.springboot.controller;

import com.springboot.springboot.Repository.AuthorRepository;
import com.springboot.springboot.Repository.BookRepository;
import com.springboot.springboot.Repository.CategoryRepository;
import com.springboot.springboot.exception.ResourceNotFoundException;
import com.springboot.springboot.model.Author;
import com.springboot.springboot.model.Book;
import com.springboot.springboot.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/Book")
public class BookController {

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @GetMapping
    public List<Book> findAll()
    {
        return bookRepository.findAll();
    }

    @PostMapping(value = "/{category_id}/{author_id}")
    public Book creatBook(@RequestBody Book book,@PathVariable long author_id, @PathVariable long category_id)
    {
        Author author=authorRepository.findById(author_id).orElseThrow(()-> new ResourceNotFoundException("Author not exist with id: "+author_id));;
        Category category = categoryRepository.findById(category_id).orElseThrow(()-> new ResourceNotFoundException("category not exist with id: "+category_id));
        book.setAuthor(author);
        book.setCategory(category);
        return bookRepository.save(book);
    }

    @GetMapping("{id}")
    public ResponseEntity<Book> getBookByID(@PathVariable long id)
    {
        Book book=bookRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Book not exist with id: "+id));
        return ResponseEntity.ok(book);
    }

    @PutMapping("{id}")
    public ResponseEntity<Book> updateBook(@PathVariable long id,@RequestBody Book book)
    {
        Book updated=bookRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Book not exist with id: "+id));
        updated.setBook_Name(book.getBook_Name());
        updated.setCategory(book.getCategory());
        updated.setAuthor(book.getAuthor());
        //updated.setBorrowing_Details(book.getBorrowing_Details());
        updated.setDateOfPublication(book.getDateOfPublication());

        bookRepository.save(updated);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Book> deleteBook(@PathVariable long id)
    {
        Book book=bookRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Book not exist with id: "+id));
        bookRepository.delete(book);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
