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
import com.ctrlaltelite.virtualpetapi.entity.VirtualPet;
import com.ctrlaltelite.virtualpetapi.service.VirtualPetService;

@RestController
@RequestMapping("/api/pets")

public class VirtualPetController {

    @Autowired
    private VirtualPetService virtualPetServ;

    // used as a way to make sure mapping is working
    @GetMapping("/ping")
    public String pingPong() {
        return "pong";
    }

    // add a new pet
    @PostMapping("/new")
    public void addUser(@RequestBody VirtualPet virtualPet) {
        this.virtualPetServ.createVirtualPet(virtualPet);
    }

    // this allows us to get all pets
    @GetMapping("/all")
    public List<VirtualPet> findAllVirtualPets() {
        return this.virtualPetServ.getAllVirtualPets();
    }

    // this allows us to find a pet by it Id
    @GetMapping("/{id}")
    public VirtualPet findVirtualPetById(@PathVariable long id) {
        return this.virtualPetServ.getVirtualPetById(id);
    }

    // this allows user to change a current pet based on id selected
    @PutMapping("/{id}")
    public VirtualPet modifyUser(@PathVariable long id, @RequestBody VirtualPet updatedVirtualPet) {
        return this.virtualPetServ.updateVirtualPet(id, updatedVirtualPet);
    }

    // this allows us to delete a pet based on its ID
    @DeleteMapping("/{id}")
    public void removeVirtualPet(@PathVariable long id) {
        this.virtualPetServ.deleteVirtualPet(id);
    }
}
