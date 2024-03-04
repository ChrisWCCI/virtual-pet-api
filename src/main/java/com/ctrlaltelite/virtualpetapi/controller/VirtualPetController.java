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

import com.ctrlaltelite.virtualpetapi.entity.VirtualPet;
import com.ctrlaltelite.virtualpetapi.service.VirtualPetService;

@RestController
public class VirtualPetController {

    @Autowired
    VirtualPetService virtualPetServ;

    @GetMapping("/ping")
    public String pingPong() {
        return "pong";
    }

    @PostMapping("/new")
    public void addUser(@RequestBody VirtualPet virtualPet) {
        this.virtualPetServ.createVirtualPet(virtualPet);
    }

    @GetMapping("/users")
    public List<VirtualPet> findAllVirtualPets() {
        return this.virtualPetServ.getAllVirtualPets();
    }

    @GetMapping("/user/{id}")
    public VirtualPet findVirtualPetById(@PathVariable long id) {
        return this.virtualPetServ.getVirtualPetById(id);
    }

    @PutMapping("/user/{id}")
    public VirtualPet modifyUser(@PathVariable long id, @RequestBody VirtualPet updatedVirtualPet) {
        return this.virtualPetServ.updateVirtualPet(id, updatedVirtualPet);
    }

    
    @DeleteMapping("/delete/{id}")
    public void removeVirtualPet(@PathVariable long id) {
        this.virtualPetServ.deleteVirtualPet(id);
    }

}
