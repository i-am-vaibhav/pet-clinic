package com.pet.clinic.services.map;

import com.pet.clinic.model.Pet;
import com.pet.clinic.services.PetService;
import org.springframework.stereotype.Service;

@Service
public class PetMapService extends AbstractMapService<Pet, Long> implements PetService {

}
