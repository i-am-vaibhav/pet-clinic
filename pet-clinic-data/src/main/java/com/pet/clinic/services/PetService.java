package com.pet.clinic.services;

import com.pet.clinic.model.Pet;

import java.util.Set;

public interface PetService {

    Set<Pet> findAll();


    Pet save(Pet owner);

    Pet findById(Long id);

}
