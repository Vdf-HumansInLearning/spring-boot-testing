package com.vdf.demo.pet;

import com.vdf.demo.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Component
public class PetServiceClient {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${pet.api.base.url}")
    private String baseUrl;

    public void createPet(Pet pet) {
        restTemplate.postForLocation(baseUrl, pet);
    }

    public SimplePet getSimplePet(long id) {
      String getUrl = baseUrl + "/{id}";
      return restTemplate.getForObject(getUrl, SimplePet.class, id);
    }

    public Pet getPetWithExchange(int id) {
        String getUrl = baseUrl + "/" + id;
        HttpEntity<Void> requestEntity = new HttpEntity<>(null, null);
        try {
            ResponseEntity<Pet> result = restTemplate.exchange(getUrl, HttpMethod.GET, requestEntity, Pet.class);
            if (HttpStatus.OK.equals(result.getStatusCode())) {
                return result.getBody();
            }
        } catch (HttpClientErrorException e) {
            if(HttpStatus.NOT_FOUND.equals(e.getStatusCode())) {
                throw new NotFoundException(String.format("Pet with id %s not found", id));
            }
            throw e;
        }
        return null;
    }

}
