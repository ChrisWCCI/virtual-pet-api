package com.ctrlalelite.virtualpetapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ctrlalelite.virtualpetapi.entity.;
import com.ctrlalelite.virtualpetapi.service.;

@RestController
public class virtualPetController {

    @Autowired
    UserService userServ;

    @GetMapping("/ping")
    public String pingPong() {
        return "pong";
    }

    @PostMapping("/new")
    public void addUser(@RequestBody User user) {
        this.userServ.createUser(user);
    }

    @GetMapping("/users")
    public List<User> findAllUsers() {
        return this.userServ.getAllUsers();
    }

    @GetMapping("/user/{id}")
    public User findUserById(@PathVariable long id) {
        return this.userServ.getUserById(id);
    }

    @PutMapping("/user/{id}")
    public User modifyUser(@PathVariable long id, @RequestBody User updatedUser) {
        return this.userServ.updateUser(id, updatedUser);
    }

}
