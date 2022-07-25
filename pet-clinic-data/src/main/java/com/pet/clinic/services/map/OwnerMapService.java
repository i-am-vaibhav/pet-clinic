package com.pet.clinic.services.map;

import com.pet.clinic.model.Owner;
import com.pet.clinic.model.Pet;
import com.pet.clinic.model.PetType;
import com.pet.clinic.services.OwnerService;
import com.pet.clinic.services.PetService;
import com.pet.clinic.services.PetTypeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Slf4j
@Service
@Profile({"map","default"})
public class OwnerMapService extends AbstractMapService<Owner, Long> implements OwnerService {

    private final PetTypeService petTypeService;
    private final PetService petService;

    public OwnerMapService(PetTypeService petTypeService, PetService petService) {
        this.petTypeService = petTypeService;
        this.petService = petService;
    }

    @Override
    public Owner findByLastName(String lastName) {
        return map.values().stream().filter(owner -> lastName.equalsIgnoreCase(owner.getLastName())).findFirst().orElse(null);
    }

    @Override
    public Owner save(Owner owner) {
        if (owner != null) {
            final Set<Pet> pets = owner.getPets();
            if (pets != null) {
                for (Pet pet : pets) {
                    final PetType type = pet.getType();
                    if (type != null) {
                        if (type.getId() == null) {
                            pet.setType(petTypeService.save(type));
                        }
                    } else {
                        throw new RuntimeException("Pet Type is required");
                    }
                    if (pet.getId() == null) {
                        Pet savedPet = petService.save(pet);
                        pet.setId(savedPet.getId());
                    }
                }
            }
            return super.save(owner);
        }
        return null;

    }
}
