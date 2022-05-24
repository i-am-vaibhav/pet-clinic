package com.pet.clinic.services.map;

import com.pet.clinic.model.Owner;
import com.pet.clinic.services.OwnerService;

public class OwnerMapService extends AbstractMapService<Owner, Long> implements OwnerService {

    @Override
    public Owner save(Owner object) {
        return super.save(object.getId(), object);
    }

    @Override
    public Owner findByLastName(String lastName) {
        return null;
    }
}
