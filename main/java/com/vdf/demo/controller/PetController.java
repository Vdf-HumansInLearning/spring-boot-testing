package com.vdf.demo.controller;

import com.vdf.demo.api.PetsApi;
import com.vdf.demo.model.Pet;
import java.util.List;
import org.springframework.http.ResponseEntity;

public class PetController implements PetsApi {

    @Override
    public ResponseEntity<Void> createPets() {
        return null;
    }

    @Override
    public ResponseEntity<List<Pet>> listPets(Integer limit) {
        return null;
    }

    @Override
    public ResponseEntity<Pet> showPetById(String petId) {
        return null;
    }
}
