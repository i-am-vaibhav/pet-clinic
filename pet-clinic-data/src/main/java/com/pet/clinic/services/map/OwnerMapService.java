package com.pet.clinic.services.map;

import com.pet.clinic.model.Owner;
import com.pet.clinic.services.OwnerService;
import org.springframework.stereotype.Service;

@Service
public class OwnerMapService extends AbstractMapService<Owner, Long> implements OwnerService {

    @Override
    public Owner findByLastName(String lastName) {
        return null;
    }
}
