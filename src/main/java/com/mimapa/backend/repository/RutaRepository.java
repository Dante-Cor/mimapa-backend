package com.mimapa.backend.repository;

import com.mimapa.backend.model.Ruta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface RutaRepository extends JpaRepository<Ruta, Integer> {

    // 1. Consulta LIGERA para el Menú Lateral (Cero geometrías pesadas)
    @Query(value = """
        SELECT 
            id_ruta AS "idRuta", 
            id_sistema AS "idSistema", 
            nombre, 
            sigla, 
            subtitulo, 
            color_hex AS "colorHex" 
        FROM rutas 
        ORDER BY id_sistema ASC, id_ruta ASC
    """, nativeQuery = true)
    List<Map<String, Object>> findAllRutasParaMenu();

    // 2. Consulta PESADA para el Mapa Leaflet (Une la metadata con los trazos)
    @Query(value = """
        SELECT 
            r.id_ruta AS "idLinea", 
            r.nombre, 
            r.color_hex AS "colorHex", 
            rt.sentido, 
            ST_AsText(rt.geom) AS geom 
        FROM rutas r 
        JOIN rutas_trazos rt ON r.id_ruta = rt.id_ruta
    """, nativeQuery = true)
    List<Map<String, Object>> findAllRutasConGeometria();
}