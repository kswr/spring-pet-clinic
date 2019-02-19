package com.kswr.pet.clinic.bootstrap;

import com.kswr.pet.clinic.model.Owner;
import com.kswr.pet.clinic.model.PetType;
import com.kswr.pet.clinic.model.Vet;
import com.kswr.pet.clinic.services.OwnerService;
import com.kswr.pet.clinic.services.PetTypeService;
import com.kswr.pet.clinic.services.VetService;
import com.kswr.pet.clinic.services.map.OwnerServiceMap;
import com.kswr.pet.clinic.services.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService  petTypeService;

    public DataLoader(VetService vetService, OwnerService ownerService, PetTypeService petTypeService) {
        this.vetService = vetService;
        this.ownerService = ownerService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) {

        PetType petType1 = new PetType();
        petType1.setName("Dog");
        PetType savedDogPetType = petTypeService.save(petType1);

        PetType petType2 = new PetType();
        petType2.setName("Cat");
        PetType savedCatPetType = petTypeService.save(petType2);

        Owner owner1 = new Owner();
        owner1.setFirstName("Vladimir");
        owner1.setLastName("Kowalski");
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Boromir");
        owner2.setLastName("TheGrey");
        ownerService.save(owner2);

        System.out.println("Loaded owners...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Michael");
        vet1.setLastName("Weston");
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Damien");
        vet2.setLastName("Black");
        vetService.save(vet2);

        System.out.println("Loaded vets...");
    }

}
