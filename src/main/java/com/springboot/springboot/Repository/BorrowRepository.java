package com.springboot.springboot.Repository;

import com.springboot.springboot.model.Book;
import com.springboot.springboot.model.Books_Out_On_Loan;
import com.springboot.springboot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BorrowRepository extends JpaRepository<Books_Out_On_Loan,Long> {
    Books_Out_On_Loan findByUserAndBook(User user, Book book);
}
