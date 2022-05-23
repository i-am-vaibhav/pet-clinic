package com.pet.clinic.services;

import com.pet.clinic.model.Vet;

import java.util.Set;

public interface VetService {

    Vet findByLastName(String lastName);

    Set<Vet> findAll();

    Vet save(Vet owner);

    Vet findById(Long id);

}
