package com.kswr.pet.clinic.services;

import com.kswr.pet.clinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long>{

    Owner findByLastName(String lastName);
}
