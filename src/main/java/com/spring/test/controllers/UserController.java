package com.spring.test.controllers;

import com.spring.test.models.User;
import com.spring.test.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class UserController {

    @Autowired
    private UserRepository repository;

    @PostMapping("/user")
    public User create(@RequestBody User reqUser) {
        User user = new User(reqUser.getName(), reqUser.getLimit(), reqUser.getRisk());

        return repository.save(user);
    }

    @GetMapping("/user")
    public List<User> list() {
        return repository.findAll();
    }
}
