package com.pet.clinic.repository;

import com.pet.clinic.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetRepository extends
        JpaRepository<Pet,Long> {
}
