package com.ijse.Hello.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;

@RestController

public class HelloController {

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello World";
    }

    @GetMapping("/hello2")
    public String sayCosa() {
        return "Hello Cosa";
    }

    @PutMapping("/updateProduct")
    public String update() {

        return "Updating Product";
    }

}
