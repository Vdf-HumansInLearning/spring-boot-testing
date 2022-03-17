package com.vdf.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Profile("!prod")
public class HelloController {

    @Value("${spring.datasource.url}")
    private String dataSourceUrl;

    @GetMapping("/")
    public String index() {
        System.out.println("test");
        return "Greetings from Spring Boot!" + dataSourceUrl;
    }

}
