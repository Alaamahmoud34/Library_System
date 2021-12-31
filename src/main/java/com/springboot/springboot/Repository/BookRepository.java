package com.springboot.springboot.Repository;

import com.springboot.springboot.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Long> {
    //All crud methods
}
