package com.pet.clinic.repository;

import com.pet.clinic.model.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OwnerRepository extends
        JpaRepository<Owner,Long> {
}
