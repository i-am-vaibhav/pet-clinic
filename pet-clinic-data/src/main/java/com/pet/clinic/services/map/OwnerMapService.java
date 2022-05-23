package com.pet.clinic.services.map;

import com.pet.clinic.model.Owner;
import com.pet.clinic.services.BaseService;

public class OwnerMapService extends AbstractMapService<Owner,Long> implements BaseService<Owner,Long> {

    @Override
    public Owner save(Owner object) {
        return super.save(object.getId(),object);
    }

}
