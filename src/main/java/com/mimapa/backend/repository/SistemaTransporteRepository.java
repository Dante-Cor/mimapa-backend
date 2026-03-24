package com.mimapa.backend.repository;

import com.mimapa.backend.model.SistemaTransporte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SistemaTransporteRepository extends JpaRepository<SistemaTransporte, Integer> {

    // ¡Literalmente no tienes que escribir NADA aquí adentro por ahora!

}