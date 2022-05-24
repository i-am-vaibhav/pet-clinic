package com.pet.clinic.services.map;

import com.pet.clinic.model.Vet;
import com.pet.clinic.services.VetService;
import org.springframework.stereotype.Service;

@Service
public class VetMapService extends AbstractMapService<Vet, Long> implements VetService {

    @Override
    public Vet save(Vet object) {
        return super.save(object.getId(), object);
    }

}
