package com.springboot.springboot.controller;

import com.springboot.springboot.Repository.UserRepository;
import com.springboot.springboot.exception.ResourceNotFoundException;
import com.springboot.springboot.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/User")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<User> findAll()
    {
        return userRepository.findAll();
    }

    @PostMapping
    public User creatBook(@RequestBody User user)
    {
        return userRepository.save(user);
    }

    @GetMapping("{id}")
    public ResponseEntity<User> getBookByID(@PathVariable long id)
    {
        User user= userRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("User not exist with id: "+id));
        return ResponseEntity.ok(user);
    }

    @PutMapping("{id}")
    public ResponseEntity<User> updateBook(@PathVariable long id,@RequestBody User user)
    {
        User updated= userRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("User not exist with id: "+id));
        updated.setUser_name(user.getUser_name());
        updated.setEmail(user.getEmail());
        updated.setPhone_Number(user.getPhone_Number());
        updated.setUser_Address(user.getUser_Address());

        userRepository.save(updated);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<User> deleteBook(@PathVariable long id)
    {
        User user= userRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("User not exist with id: "+id));
        userRepository.delete(user);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}