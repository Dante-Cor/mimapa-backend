package com.mimapa.backend.controller;

import com.mimapa.backend.repository.RutaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/rutas")
@CrossOrigin(origins = "*")
public class RutaController {

    @Autowired
    private RutaRepository rutaRepository;

    // Endpoint: http://localhost:8081/api/rutas/menu
    @GetMapping("/menu")
    public List<Map<String, Object>> getMenu() {
        return rutaRepository.findAllRutasParaMenu();
    }

    // Endpoint: http://localhost:8081/api/rutas/trazos
    @GetMapping("/trazos")
    public List<Map<String, Object>> getTrazos() {
        return rutaRepository.findAllRutasConGeometria();
    }
}