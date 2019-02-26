package com.kswr.pet.clinic.services.springdatajpa;

import com.kswr.pet.clinic.model.Owner;
import com.kswr.pet.clinic.repositories.OwnerRepository;
import com.kswr.pet.clinic.repositories.PetRepository;
import com.kswr.pet.clinic.repositories.PetTypeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest {

    public static final String LAST_NAME = "Smith";
    @Mock
    private OwnerRepository ownerRepository;

    @Mock
    private PetRepository petRepository;

    @Mock
    private PetTypeRepository petTypeRepository;

    private Owner returnOwner;

    @InjectMocks
    OwnerSDJpaService service;

    @BeforeEach
    void setUp() {
        returnOwner = Owner.ownerBuilder().id(1L).lastName(LAST_NAME).build();
    }

    @Test
    void findByLastName() {
        when(ownerRepository.findByLastName(any())).thenReturn(returnOwner);
        Owner smith = service.findByLastName(LAST_NAME);

        assertEquals(returnOwner.getId(), smith.getId());
        assertEquals(returnOwner.getLastName(),smith.getLastName());
        verify(ownerRepository, times(1)).findByLastName(any());
    }

    @Test
    void findAll() {
        Set<Owner> owners = new HashSet<>();
        Set<Owner> returnOwners;
        owners.add(Owner.ownerBuilder().id(2L).build());
        owners.add(Owner.ownerBuilder().id(3L).build());
        when(ownerRepository.findAll()).thenReturn(owners);
        returnOwners = service.findAll();

        assertNotNull(returnOwners);
        assertEquals(2, returnOwners.size());
        verify(ownerRepository, times(1)).findAll();
    }

    @Test
    void findById() {
        when(ownerRepository.findById(any())).thenReturn(Optional.of(returnOwner));
        Owner owner = service.findById(1L);

        assertNotNull(owner);
        assertEquals(owner.getLastName(),returnOwner.getLastName());
    }

    @Test
    void findByIdNotFound() {
        when(ownerRepository.findById(any())).thenReturn(Optional.empty());
        Owner owner = service.findById(1L);

        assertNull(owner);
    }

    @Test
    void save() {
        Owner owner = Owner.ownerBuilder().id(1L).lastName(LAST_NAME).build();
        when(ownerRepository.save(any())).thenReturn(owner);
        Owner savedOwner = service.save(owner);
        assertNotNull(savedOwner);
        assertEquals(owner.getId(), savedOwner.getId());
        assertEquals(owner.getLastName(), savedOwner.getLastName());
        verify(ownerRepository, times(1)).save(any());
    }

    @Test
    void delete() {
        service.delete(returnOwner);
        verify(ownerRepository, times(1)).delete(any());
    }

    @Test
    void deleteById() {
        service.deleteById(returnOwner.getId());
        verify(ownerRepository, times(1)).deleteById(anyLong());
    }
}