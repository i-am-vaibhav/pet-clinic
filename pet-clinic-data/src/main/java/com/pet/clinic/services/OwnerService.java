package com.pet.clinic.services;

import com.pet.clinic.model.Owner;

import java.util.Set;

public interface OwnerService {

    Owner findByLastName(String lastName);

    Set<Owner> findAll();

    Owner save(Owner owner);

    Owner findById(Long id);

}
