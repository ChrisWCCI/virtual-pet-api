package com.ctrlaltelite.virtualpetapi.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "\"virtualPet\"")

public class VirtualPet {

    public VirtualPet(Long petID, String petName, String petDescription, long hungerLevel, long thirstLevel, long boredomLevel, List<VirtualPet> virtualPets) {
        this.petName = petName;
        this.petDescription = petDescription;
        this.hungerLevel = hungerLevel;
        this.thirstLevel = thirstLevel;
        this.boredomLevel = boredomLevel;
    }

    public VirtualPet() {

    }

    public String getPetName() {
        return this.petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public String getPetDescription() {
        return this.petDescription;
    }

    public void setPetDescription(String petDescription) {
        this.petDescription = petDescription;
    }

    public long getHungerLevel() {
        return this.hungerLevel;
    }

    public void setHungerLevel(long hungerLevel) {
        this.hungerLevel = hungerLevel;
    }

    public long getThirstLevel() {
        return this.thirstLevel;
    }

    public void setThirstLevel(long thirstLevel) {
        this.thirstLevel = thirstLevel;
    }

    public long getBoredomLevel() {
        return this.boredomLevel;
    }

    public void setBoredomLevel(long boredomLevel) {
        this.boredomLevel = boredomLevel;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "petId")
    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "petName")
    private String petName;

    @Column(name = "petDescription")
    private String petDescription;

    @Column(name = "hungerLevel")
    private long hungerLevel;

    @Column(name = "thirstLevel")
    private long thirstLevel;

    @Column(name = "boredomLevel")
    private long boredomLevel;

}
