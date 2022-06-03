package com.pet.clinic.services.map;

import com.pet.clinic.model.Speciality;
import com.pet.clinic.model.Vet;
import com.pet.clinic.services.SpecialityService;
import com.pet.clinic.services.VetService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class VetMapService extends AbstractMapService<Vet, Long> implements VetService {

    private final SpecialityService specialityService;

    public VetMapService(SpecialityService specialityService) {
        this.specialityService = specialityService;
    }

    @Override
    public Vet save(Vet vet) {
        if (vet != null) {
            final Set<Speciality> specialities = vet.getSpecialities();
            if (specialities.size() != 0) {
                specialities.forEach(sp -> {
                    if (sp.getId() == null) {
                        final Speciality save = specialityService.save(sp);
                        sp.setId(save.getId());
                    }
                });
            }
        }
        return super.save(vet);
    }
}
