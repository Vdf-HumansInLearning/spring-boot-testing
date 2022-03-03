package com.vdf.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Value("${spring.datasource.url}")
    private String dataSourceUrl;

    @GetMapping("/")
    public String index() {
        return "Greetings from Spring Boot!" + dataSourceUrl;
    }

}
