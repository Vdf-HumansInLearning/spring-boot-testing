package com.vdf.demo;

import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MyBean {

    @Value("${test}")
    private String property;

    @PostConstruct
    public void init() {
        System.out.println(property);
    }

}
