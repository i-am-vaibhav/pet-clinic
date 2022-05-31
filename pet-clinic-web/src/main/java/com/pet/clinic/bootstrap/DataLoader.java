package com.pet.clinic.bootstrap;

import com.pet.clinic.model.Owner;
import com.pet.clinic.model.Pet;
import com.pet.clinic.model.PetType;
import com.pet.clinic.model.Vet;
import com.pet.clinic.services.OwnerService;
import com.pet.clinic.services.PetTypeService;
import com.pet.clinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("dog");
        PetType cat = new PetType();
        cat.setName("cat");
        PetType savedDog = petTypeService.save(dog);
        PetType savedCat = petTypeService.save(cat);

        Owner owner1 = new Owner();
        owner1.setId(1l);
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
        owner1.getPets().add(vaibhavPet);
        ownerService.save(owner1);


        Owner owner2 = new Owner();
        owner2.setId(2l);
        owner2.setFirstName("Prinsee");
        owner2.setLastName("Gupta");
        owner2.setAddress("Bada Bazar");
        owner2.setCity("Chrm");
        owner2.setMobile("9876543456");


        Pet prinseePet = new Pet();
        prinseePet.setBirthDate(LocalDate.now());
        prinseePet.setType(savedCat);
        prinseePet.setName("Tinny");
        prinseePet.setOwner(owner1);
        owner2.getPets().add(prinseePet);
        ownerService.save(owner2);
        System.out.println("Loaded Owners");
        Vet vet1 = new Vet();
        vet1.setFirstName("Banku");
        vet1.setLastName("Gupta");
        vetService.save(vet1);
        Vet vet2 = new Vet();
        vet2.setFirstName("Ansul");
        vet2.setLastName("Gupta");
        vetService.save(vet2);
        System.out.println("Loaded Vets");
    }
}
