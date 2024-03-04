package com.ctrlaltelite.virtualpetapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ctrlaltelite.virtualpetapi.entity.VirtualPet;
import com.ctrlaltelite.virtualpetapi.service.VirtualPetService;

@RestController
@RequestMapping("/pet")

public class VirtualPetController {

    @Autowired
    private VirtualPet virtualPet;

    @GetMapping("/ping")
    public String pingPong() {
        return "pong";
    }

    @PostMapping("/new")
    public void addUser(@RequestBody VirtualPet virtualPet) {
        this.virtualPet.createUser(virtualPet);
    }

    @GetMapping("/users")
    public List<VirtualPet> findAllUsers() {
        return this.virtualPet.getAllUsers();
    }

    @GetMapping("/user/{id}")
    public VirtualPet findUserById(@PathVariable long id) {
        return this.virtualPet.getUserById(id);
    }

    @PutMapping("/user/{id}")
    public VirtualPet modifyUser(@PathVariable long id, @RequestBody VirtualPet updatedUser) {
        return this.virtualPet.updateUser(id, updatedUser);
    }

    @DeleteMapping("/delete/{id}")
    public void removeUser(@PathVariable long id) {
        this.virtualPet.deleteUser(id);
    }

}
