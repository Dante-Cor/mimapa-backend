package com.mimapa.backend.controller;

import com.mimapa.backend.model.LineaTrazo;
import com.mimapa.backend.service.LineaTrazoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/lineas") // ¡Esta será tu nueva URL!
@CrossOrigin(origins = "*")
public class LineaTrazoController {

    private final LineaTrazoService service;

    @Autowired
    public LineaTrazoController(LineaTrazoService service) {
        this.service = service;
    }

    @GetMapping
    public List<LineaTrazo> obtenerLineas() {
        return service.obtenerTodasLasLineas(); // Nombre de método actualizado
    }
}