package com.pet.clinic.repository;

import com.pet.clinic.model.PetType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetTypeRepository extends
        JpaRepository<PetType, Long> {
}
