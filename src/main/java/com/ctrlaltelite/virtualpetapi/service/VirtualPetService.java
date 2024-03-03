package com.ctrlaltelite.virtualpetapi.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service

public class VirtualPetService {

    @Autowired
    private UserRepository userRepo;

    /*
     * Adds a new User to the repository (db). The "C" (create) in CRUD
     */
    public void createUser(User u) {
        this.userRepo.save(u);
    }

    /*
     * Gets all the users in the repo (db). The "R" (read) in CRUD
     */
    public List<User> getAllUsers() {
        return this.userRepo.findAll();
    }

    /*
     * Gets a specific User by its id. The "R" (read) in CRUD
     */
    public User getUserById(long id) {
        return this.userRepo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found: " + id));
    }

    /*
     * Updates an existing user, found by a specific id. The "U" (update) in CRUD
     */
    public User updateUser(long id, User updatedUser) {
        User existingUser = this.userRepo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found: " + id));

        // The other way of updating
        existingUser.setName(updatedUser.getName());
        existingUser.setEmail(updatedUser.getEmail());
        this.userRepo.save(existingUser);

        return existingUser;
    }

    /*
     * Delete a user from the repo. The "D" (delete) in CRUD
     */
    public void deleteUser(long id) {
        this.userRepo.deleteById(id);
    }
}

