package com.mimapa.backend.controller;

import com.mimapa.backend.repository.EstacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable; // <- Esta era la clave
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/estaciones")
@CrossOrigin(origins = "*")
public class EstacionController {

    @Autowired
    private EstacionRepository estacionRepository;

    @GetMapping
    public List<Map<String, Object>> getAllEstaciones() {
        return estacionRepository.findAllEstacionesConGeometria();
    }

    // NUEVO ENDPOINT PARA EL ITINERARIO
    @GetMapping("/linea/{id}/itinerario")
    public List<Map<String, Object>> getItinerario(@PathVariable Integer id) {
        return estacionRepository.findItinerarioByLinea(id);
    }
}