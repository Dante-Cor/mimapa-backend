package com.mimapa.backend.controller;

import com.mimapa.backend.model.SistemaTransporte;
import com.mimapa.backend.service.SistemaTransporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/sistemas")
@CrossOrigin(origins = "*") // Permite que tu Frontend en otro puerto consuma esta API sin que el navegador lo bloquee
public class SistemaTransporteController {

    private final SistemaTransporteService service;

    @Autowired
    public SistemaTransporteController(SistemaTransporteService service) {
        this.service = service;
    }

    // Cuando alguien entre a /api/sistemas con un método GET, se ejecuta esto:
    @GetMapping
    public List<SistemaTransporte> obtenerSistemas() {
        return service.obtenerTodosLosSistemas();
    }
}