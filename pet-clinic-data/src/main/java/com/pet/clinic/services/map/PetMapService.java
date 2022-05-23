package com.pet.clinic.services.map;

import com.pet.clinic.model.Owner;
import com.pet.clinic.model.Pet;
import com.pet.clinic.services.BaseService;

public class PetMapService extends AbstractMapService<Pet,Long> implements BaseService<Pet,Long> {

    @Override
    public Pet save(Pet object) {
        return super.save(object.getId(),object);
    }
}
