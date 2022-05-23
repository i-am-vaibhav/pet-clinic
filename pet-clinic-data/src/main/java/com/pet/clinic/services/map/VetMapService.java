package com.pet.clinic.services.map;

import com.pet.clinic.model.Owner;
import com.pet.clinic.model.Vet;
import com.pet.clinic.services.BaseService;

public class VetMapService extends AbstractMapService<Vet,Long> implements BaseService<Vet,Long> {

    @Override
    public Vet save(Vet object) {
        return super.save(object.getId(),object);
    }

}
