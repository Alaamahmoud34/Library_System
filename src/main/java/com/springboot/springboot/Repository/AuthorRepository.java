package com.springboot.springboot.Repository;

import com.springboot.springboot.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author,Long> {
}
