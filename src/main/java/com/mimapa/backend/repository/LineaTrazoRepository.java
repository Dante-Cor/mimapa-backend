package com.mimapa.backend.repository;

import com.mimapa.backend.model.LineaTrazo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface LineaTrazoRepository extends JpaRepository<LineaTrazo, Integer> {

    // Esta consulta SQL pura obliga a PostgreSQL a convertir la geometría a texto (WKT)
    @Query(value = "SELECT id_linea, id_sistema, nombre, color_hex, sentido, ST_AsText(geom) FROM lineas_trazos", nativeQuery = true)
    List<Object[]> findAllAsText();
}