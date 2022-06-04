package com.pet.clinic.repository;

import com.pet.clinic.model.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OwnerRepository extends
        JpaRepository<Owner, Long> {

    Optional<Owner> findByLastName(String lastName);
}
