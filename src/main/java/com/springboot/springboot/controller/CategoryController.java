package com.springboot.springboot.controller;

import com.springboot.springboot.Repository.AuthorRepository;
import com.springboot.springboot.Repository.CategoryRepository;
import com.springboot.springboot.exception.ResourceNotFoundException;
import com.springboot.springboot.model.Author;
import com.springboot.springboot.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/Category")
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping
    public List<Category> findAll()
    {
        return categoryRepository.findAll();
    }

    @PostMapping
    public Category creatCategory(@RequestBody Category category)
    {
        return categoryRepository.save(category);
    }

    @GetMapping("{id}")
    public ResponseEntity<Category> getCategoryByID(@PathVariable long id)
    {
        Category category=categoryRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Category not exist with id: "+id));
        return ResponseEntity.ok(category);
    }

    @PutMapping("{id}")
    public ResponseEntity<Category> updateAuthor(@PathVariable long id,@RequestBody Category category)
    {
        Category updated=categoryRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Author not exist with id: "+id));
        updated.setCategory_Name(category.getCategory_Name());
        //updated.setBooks(category.getBooks());

        categoryRepository.save(updated);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Author> deleteAuthor(@PathVariable long id)
    {
        Category category=categoryRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Author not exist with id: "+id));
        categoryRepository.delete(category);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
