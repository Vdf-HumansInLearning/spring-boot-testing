package com.vdf.demo.controller;

import com.vdf.demo.pet.Pet;
import com.vdf.demo.pet.PetServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PetController {


    @Autowired
    private PetServiceClient petServiceClient;

    @GetMapping("/pet/{id}")
    public Pet pet(@PathVariable int id) {
        return petServiceClient.getPetWithExchange(id);
    }
}
