package com.kswr.pet.clinic.repositories;

import com.kswr.pet.clinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<Pet, Long> {
}
