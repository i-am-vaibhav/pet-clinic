package com.pet.clinic.services;

import com.pet.clinic.model.Owner;

public interface OwnerService extends BaseService<Owner, Long> {

    Owner findByLastName(String lastName);

}
