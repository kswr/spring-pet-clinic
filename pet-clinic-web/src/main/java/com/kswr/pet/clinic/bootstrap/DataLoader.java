package com.kswr.pet.clinic.bootstrap;

import com.kswr.pet.clinic.model.Owner;
import com.kswr.pet.clinic.model.Vet;
import com.kswr.pet.clinic.services.OwnerService;
import com.kswr.pet.clinic.services.VetService;
import com.kswr.pet.clinic.services.map.OwnerServiceMap;
import com.kswr.pet.clinic.services.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(VetService vetService, OwnerService ownerService) {
        this.vetService = vetService;
        this.ownerService = ownerService;
    }

    @Override
    public void run(String... args) throws Exception {

        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Vladimir");
        owner1.setLastName("Kowalski");
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Boromir");
        owner2.setLastName("TheGrey");
        ownerService.save(owner2);

        System.out.println("Loaded owners...");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Michael");
        vet1.setLastName("Weston");
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("Damien");
        vet2.setLastName("Black");
        vetService.save(vet2);

        System.out.println("Loaded vets...");

        vetService.save(new Vet());
    }

}
