package com.mimapa.backend.repository;

import com.mimapa.backend.model.Estacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface EstacionRepository extends JpaRepository<Estacion, Integer> {

    // 1. Dibuja las bolitas en el mapa (Ajustado a la nueva tabla 'rutas')
    @Query(value = """
        SELECT 
            e.id_estacion AS id, 
            e.nombre, 
            e.tipo, 
            e.nivel, 
            e.municipio, 
            e.estatus_operativo AS "estatusOperativo", 
            el.orden, 
            el.direction_id AS "directionId",
            el.destino,
            r.id_ruta AS "idLinea", 
            r.id_sistema AS "idSistema", 
            ST_AsText(e.geom) AS geom
        FROM estaciones e
        JOIN estacion_linea el ON e.id_estacion = el.id_estacion
        JOIN rutas r ON el.id_linea = r.id_ruta
    """, nativeQuery = true)
    List<Map<String, Object>> findAllEstacionesConGeometria();

    // 2. Itinerario agrupado y ordenado como estándar GTFS
    @Query(value = """
        SELECT 
            e.nombre, 
            el.orden, 
            e.tipo,
            e.estatus_operativo AS "estatusOperativo",
            el.direction_id AS "directionId",
            el.destino
        FROM estaciones e
        JOIN estacion_linea el ON e.id_estacion = el.id_estacion
        WHERE el.id_linea = :idLinea
        ORDER BY el.direction_id ASC, el.orden ASC
    """, nativeQuery = true)
    List<Map<String, Object>> findItinerarioByLinea(@Param("idLinea") Integer idLinea);
}