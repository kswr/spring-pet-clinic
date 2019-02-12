package com.kswr.pet.clinic.services;

import com.kswr.pet.clinic.model.Pet;

import java.util.Set;

public interface PetService {

    Set<Pet> findAll();
    Pet findById(Long id);
    Pet save(Pet pet);
}
