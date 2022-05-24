package com.pet.clinic.bootstrap;

import com.pet.clinic.model.Owner;
import com.pet.clinic.model.Vet;
import com.pet.clinic.services.OwnerService;
import com.pet.clinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = new Owner();
        owner1.setId(1l);
        owner1.setFirstName("Vaibhav");
        owner1.setLastName("Gupta");
        ownerService.save(owner1);
        Owner owner2 = new Owner();
        owner2.setId(2l);
        owner2.setFirstName("Prinsee");
        owner2.setLastName("Gupta");
        ownerService.save(owner2);
        System.out.println("Loaded Owners");
        Vet vet1 = new Vet();
        vet1.setId(3l);
        vet1.setFirstName("Banku");
        vet1.setLastName("Gupta");
        vetService.save(vet1);
        Vet vet2 = new Vet();
        vet2.setId(4l);
        vet2.setFirstName("Ansul");
        vet2.setLastName("Gupta");
        vetService.save(vet2);
        System.out.println("Loaded Vets");
    }
}
