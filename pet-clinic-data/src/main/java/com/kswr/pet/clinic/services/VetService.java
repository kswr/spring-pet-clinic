package com.kswr.pet.clinic.services;

import com.kswr.pet.clinic.model.Vet;

import java.util.Set;

public interface VetService {

    Vet save(Vet vet);
    Vet findById(Long id);
    Set<Vet> findAll();
}
