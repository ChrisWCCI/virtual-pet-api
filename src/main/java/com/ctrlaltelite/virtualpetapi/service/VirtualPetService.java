package com.ctrlaltelite.virtualpetapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.server.ResponseStatusException;

import com.ctrlaltelite.virtualpetapi.entity.VirtualPet;
import com.ctrlaltelite.virtualpetapi.repository.VirtualPetRepository;

@Service
public class VirtualPetService {

    @Autowired
    private VirtualPetRepository virtualPetRepo;

    /*
     * Adds a new User to the repository (db). The "C" (create) in CRUD
     */
    public void createVirtualPet(VirtualPet virtualPetNew) {
        this.virtualPetRepo.save(virtualPetNew);
    }

    /*
     * Gets all the users in the repo (db). The "R" (read) in CRUD
     */
    public List<VirtualPet> getAllVirtualPets() {
        return this.virtualPetRepo.findAll();
    }

    /*
     * Gets a specific User by its id. The "R" (read) in CRUD
     */
    public VirtualPet getVirtualPetById(long id) {
        return this.virtualPetRepo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pet not found: " + id));
    }

    /*
     * Updates an existing user, found by a specific id. The "U" (update) in CRUD
     */
    public VirtualPet updateVirtualPet(long id, VirtualPet updatedVirtualPet) {
        VirtualPet existingVirtualPet = this.virtualPetRepo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pet not found: " + id));

        // The other way of updating
        existingVirtualPet.setId(updatedVirtualPet.getId());
        existingVirtualPet.setPetName(updatedVirtualPet.getPetName());
        existingVirtualPet.setPetDescription(updatedVirtualPet.getPetDescription());
        existingVirtualPet.setHungerLevel(updatedVirtualPet.getHungerLevel());
        existingVirtualPet.setThirstLevel(updatedVirtualPet.getThirstLevel());
        existingVirtualPet.setBoredomLevel(updatedVirtualPet.getBoredomLevel());
        this.virtualPetRepo.save(existingVirtualPet);
        return existingVirtualPet;
    }

    public void deleteVirtualPet(long id) {
        this.virtualPetRepo.deleteById(id);
    }
}
