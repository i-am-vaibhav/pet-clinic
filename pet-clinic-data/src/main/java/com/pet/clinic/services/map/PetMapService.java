package com.pet.clinic.services.map;

import com.pet.clinic.model.Pet;
import com.pet.clinic.services.PetService;

public class PetMapService extends AbstractMapService<Pet, Long> implements PetService {

    @Override
    public Pet save(Pet object) {
        return super.save(object.getId(), object);
    }
}
