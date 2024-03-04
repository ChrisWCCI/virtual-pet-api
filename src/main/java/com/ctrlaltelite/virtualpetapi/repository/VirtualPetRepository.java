package com.ctrlaltelite.virtualpetapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ctrlaltelite.virtualpetapi.entity.VirtualPet;

@Repository
public interface VirtualPetRepository extends JpaRepository<VirtualPet, Long> {

}
