package com.springboot.springboot.controller;

import com.springboot.springboot.Repository.AuthorRepository;
import com.springboot.springboot.exception.ResourceNotFoundException;
import com.springboot.springboot.model.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/Author")
public class AuthorController {

    @Autowired
    private AuthorRepository authorRepository;

    @GetMapping
    public List<Author> findAll()
    {
        return authorRepository.findAll();
    }

    @PostMapping
    public Author creatAuthor(@RequestBody Author author)
    {
        return authorRepository.save(author);
    }

    @GetMapping("{id}")
    public ResponseEntity<Author> getAuthorByID(@PathVariable long id)
    {
        Author author=authorRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Author not exist with id: "+id));
        return ResponseEntity.ok(author);
    }

    @PutMapping("{id}")
    public ResponseEntity<Author> updateAuthor(@PathVariable long id,@RequestBody Author author)
    {
        Author updated=authorRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Author not exist with id: "+id));
        updated.setAuthor_Name(author.getAuthor_Name());
        //updated.setBooks(author.getBooks());

        authorRepository.save(updated);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Author> deleteAuthor(@PathVariable long id)
    {
        Author author=authorRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Author not exist with id: "+id));
        authorRepository.delete(author);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
