package com.kswr.pet.clinic.bootstrap;

import com.kswr.pet.clinic.model.Owner;
import com.kswr.pet.clinic.model.Pet;
import com.kswr.pet.clinic.model.PetType;
import com.kswr.pet.clinic.model.Vet;
import com.kswr.pet.clinic.services.OwnerService;
import com.kswr.pet.clinic.services.PetTypeService;
import com.kswr.pet.clinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

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
        owner1.setAddress("Jasna 1");
        owner1.setCity("Warsaw");
        owner1.setTelephone("123412341");

        Pet pet1 = new Pet();
        pet1.setPetType(savedDogPetType);
        pet1.setOwner(owner1);
        pet1.setBirthDate(LocalDate.now());
        pet1.setName("Rosco");

        owner1.getPets().add(pet1);
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Boromir");
        owner2.setLastName("TheGrey");
        owner2.setAddress("Złota 2");
        owner2.setCity("Gdańsk");
        owner2.setTelephone("123412342");

        Pet pet2 = new Pet();
        pet2.setPetType(savedCatPetType);
        pet2.setOwner(owner2);
        pet2.setBirthDate(LocalDate.now());
        pet2.setName("Mouse");

        owner2.getPets().add(pet2);
        ownerService.save(owner2);

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
