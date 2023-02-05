package com.pet.clinic.services;

import com.pet.clinic.model.Owner;

import java.util.List;

public interface OwnerService extends BaseService<Owner, Long> {

    Owner findByLastName(String lastName);

    List<Owner> findAllByLastName(String lastName);

}
