package com.mimapa.backend.service;

import com.mimapa.backend.model.SistemaTransporte;
import com.mimapa.backend.repository.SistemaTransporteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SistemaTransporteService {

    private final SistemaTransporteRepository repository;

    // Inyección de dependencias (Spring nos pasa el repositorio automáticamente)
    @Autowired
    public SistemaTransporteService(SistemaTransporteRepository repository) {
        this.repository = repository;
    }

    // Método que usaremos para obtener la lista completa
    public List<SistemaTransporte> obtenerTodosLosSistemas() {
        // ¡Aquí usamos el método abstracto que Spring implementó por nosotros!
        return repository.findAll();
    }
}
