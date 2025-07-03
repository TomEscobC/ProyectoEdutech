package com.edutech.cl.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InicioController {

    @GetMapping("/")
    public String index() {
        return "Bienvenidos a EduTech";
    }
}