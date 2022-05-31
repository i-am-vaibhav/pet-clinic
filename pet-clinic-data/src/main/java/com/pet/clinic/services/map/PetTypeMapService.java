package com.pet.clinic.services.map;

import com.pet.clinic.model.PetType;
import com.pet.clinic.services.PetTypeService;
import org.springframework.stereotype.Service;

@Service
public class PetTypeMapService extends AbstractMapService<PetType, Long> implements PetTypeService {

}
