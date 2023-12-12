package com.cocode.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class PaisController {
ex    public String testController() {
        return "Controlador pais";
    }
}
