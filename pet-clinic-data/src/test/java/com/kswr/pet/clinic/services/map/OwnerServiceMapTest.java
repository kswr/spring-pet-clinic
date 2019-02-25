package com.kswr.pet.clinic.services.map;

import com.kswr.pet.clinic.model.Owner;
import com.kswr.pet.clinic.services.OwnerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OwnerServiceMapTest {

    private OwnerService ownerService;

    private final Long ownerId = 1L;
    private final Long secondOwnerId = 2L;
    private final String lastName = "Doe";


    @BeforeEach
    void setUp() {
        ownerService = new OwnerServiceMap(new PetTypeServiceMap(), new PetServiceMap());
        ownerService.save(Owner.builder().id(ownerId).lastName(lastName).build());
    }

    @Test
    void findAll() {
        Set<Owner> ownerSet = ownerService.findAll();
        assertEquals(1, ownerSet.size());
    }

    @Test
    void findById() {
        Owner owner = ownerService.findById(ownerId);
        assertEquals(ownerId, owner.getId());
    }

    @Test
    void saveId() {
        Owner secondOwner = ownerService.save(Owner.builder().id(secondOwnerId).build());
        assertEquals(secondOwnerId, secondOwner.getId());
    }

    @Test
    void saveNoId() {
        Owner owner = ownerService.save(Owner.builder().build());
        assertNotNull(owner);
        assertNotNull(owner.getId());
    }

    @Test
    void delete() {
        ownerService.delete(ownerService.findById(ownerId));
        assertEquals(0, ownerService.findAll().size());
    }

    @Test
    void deleteById() {
        ownerService.deleteById(ownerId);
        assertEquals(0, ownerService.findAll().size());
    }

    @Test
    void findByLastNameTest() {
        Owner owner = ownerService.findByLastName(lastName);
        assertEquals(lastName, owner.getLastName());
    }

    @Test
    void notFindByLastNameTest() {
        Owner owner = ownerService.findByLastName("foo");
        assertNull(owner);
    }
}