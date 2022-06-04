package com.pet.clinic.bootstrap;

import com.pet.clinic.model.*;
import com.pet.clinic.services.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Slf4j
@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;
    private final VisitService visitService;
    private final PetService petService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialityService specialityService, VisitService visitService, PetService petService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
        this.visitService = visitService;
        this.petService = petService;
    }

    @Override
    public void run(String... args) throws Exception {
        if (petTypeService.findAll().size() == 0) {
            loadData();
            log.debug("Loaded Startup Data");
        } else {
            log.debug("Data already loaded");
        }
    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("dog");
        PetType cat = new PetType();
        cat.setName("cat");
        PetType savedDog = petTypeService.save(dog);
        PetType savedCat = petTypeService.save(cat);

        Speciality radiology = new Speciality();
        radiology.setDescription("radiology");
        Speciality savedRadiology = specialityService.save(radiology);

        Speciality dentistery = new Speciality();
        dentistery.setDescription("dentistery");
        Speciality sDentistery = specialityService.save(dentistery);

        Speciality surgery = new Speciality();
        surgery.setDescription("surgery");
        Speciality sSurgery = specialityService.save(surgery);

        Owner owner1 = new Owner();
        owner1.setFirstName("Vaibhav");
        owner1.setLastName("Gupta");
        owner1.setAddress("Bada Bazar");
        owner1.setCity("Chrm");
        owner1.setMobile("9876543456");

        Pet vaibhavPet = new Pet();
        vaibhavPet.setBirthDate(LocalDate.now());
        vaibhavPet.setType(savedDog);
        vaibhavPet.setName("Jimmy");
        vaibhavPet.setOwner(owner1);
        ownerService.save(owner1);
        vaibhavPet = petService.save(vaibhavPet);
        owner1.getPets().add(vaibhavPet);
        ownerService.save(owner1);




        Owner owner2 = new Owner();
        owner2.setFirstName("Prinsee");
        owner2.setLastName("Gupta");
        owner2.setAddress("Bada Bazar");
        owner2.setCity("Chrm");
        owner2.setMobile("9876543456");


        Pet prinseePet = new Pet();
        prinseePet.setBirthDate(LocalDate.now());
        prinseePet.setType(savedCat);
        prinseePet.setName("Tinny");
        prinseePet.setOwner(owner2);
        ownerService.save(owner2);
        prinseePet = petService.save(prinseePet);
        owner2.getPets().add(prinseePet);
        ownerService.save(owner2);

        Vet vet1 = new Vet();
        vet1.setFirstName("Banku");
        vet1.setLastName("Gupta");
        vet1.getSpecialities().add(sDentistery);
        vetService.save(vet1);
        Vet vet2 = new Vet();
        vet2.setFirstName("Ansul");
        vet2.setLastName("Gupta");
        vet2.getSpecialities().add(sSurgery);
        vetService.save(vet2);

        Visit visit=new Visit();
        visit.setDescription("prinsee cat");
        visit.setVisitDate(LocalDate.now());
        visit.setPet(prinseePet);
        visitService.save(visit);
    }
}
