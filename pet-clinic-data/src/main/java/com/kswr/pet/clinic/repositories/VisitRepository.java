package com.kswr.pet.clinic.repositories;

import com.kswr.pet.clinic.model.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitRepository extends CrudRepository<Visit, Long> {
}
