package com.vdf.demo.controller;

import com.vdf.demo.model.Employee;
import com.vdf.demo.model.User;
import com.vdf.demo.model.UserAddress;
import com.vdf.demo.persistence.UserRepository;
import java.util.Optional;
import javax.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EntityManager entityManager;

    @GetMapping(produces="application/json")
    public ResponseEntity<Void> createUser() {
        User user = new User();
        user.setName("test");
        UserAddress userAddress = new UserAddress();
        userAddress.setCity("Cluj");
        user.setAddress(userAddress);
        userAddress.setUser(user);
        userRepository.save(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/{id}",  produces="application/json")
    public ResponseEntity<User> getUser(@PathVariable Long id) {
        User user = entityManager.find(User.class, id);
        return new ResponseEntity<>(user, HttpStatus.OK);

//        Optional<User> userOptional = userRepository.findById(id);
//        return userOptional.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
//            .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

}
