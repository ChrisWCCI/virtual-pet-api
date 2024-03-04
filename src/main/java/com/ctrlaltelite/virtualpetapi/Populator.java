package com.ctrlaltelite.virtualpetapi;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.ctrlaltelite.virtualpetapi.entity.VirtualPet;
import com.ctrlaltelite.virtualpetapi.repository.VirtualPetRepository;

@Component

public class Populator implements CommandLineRunner {

    @Autowired
    private VirtualPetRepository virtualPetRepository;

    @Override
    public void run(String... args) throws Exception {
        List<VirtualPet> virtualPets = new ArrayList<VirtualPet>();

        VirtualPet virtualPets1 = new VirtualPet((long) 1, "Bandit Heeler",
                "A middle aged blue heeler who loves his family. A Rad Dad!", 50, 50, 50, virtualPets);
        virtualPetRepository.save(virtualPets1);
        VirtualPet virtualPets2 = new VirtualPet((long) 2, "Chili Heeler",
                "Wife to Bandit and Mother of Bingo and Bluey. An awesome Mum!", 50, 50, 50, virtualPets);
        virtualPetRepository.save(virtualPets2);
        VirtualPet virtualPets3 = new VirtualPet((long) 3, "Bluey Heeler",
                "She is a great big sister and the star of the show.", 50, 50, 50, virtualPets);
        virtualPetRepository.save(virtualPets3);
        VirtualPet virtualPets4 = new VirtualPet((long) 4, "Bingo Heeler",
                "She is the baby of the family but still an important part.", 50, 50, 50, virtualPets);
        virtualPetRepository.save(virtualPets4);
        VirtualPet virtualPets5 = new VirtualPet((long) 5, "Grouchy Granny",
                "She is Muffin in disguise but makes an excellent Grouchy Granny.", 50, 50, 50, virtualPets);
        virtualPetRepository.save(virtualPets5);

    }

}
