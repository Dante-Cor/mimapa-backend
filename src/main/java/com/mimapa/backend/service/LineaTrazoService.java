package com.mimapa.backend.service;

import com.mimapa.backend.model.LineaTrazo;
import com.mimapa.backend.repository.LineaTrazoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class LineaTrazoService {

    private final LineaTrazoRepository repository;

    @Autowired
    public LineaTrazoService(LineaTrazoRepository repository) {
        this.repository = repository;
    }

    public List<LineaTrazo> obtenerTodasLasLineas() {
        List<Object[]> resultados = repository.findAllAsText();
        List<LineaTrazo> lineas = new ArrayList<>();


        for (Object[] fila : resultados) {
            LineaTrazo linea = new LineaTrazo();

            try {
                // ID Línea (Posición 0) - CORREGIDO
                if (fila[0] != null) {
                    linea.setIdLinea(((Number) fila[0]).intValue());
                }

                // ID Sistema (Posición 1) - CORREGIDO
                if (fila[1] != null) {
                    linea.setIdSistema(((Number) fila[1]).intValue());
                }

                // Nombre (Posición 2)
                linea.setNombre(fila[2] != null ? fila[2].toString() : "Sin nombre");

                // Color Hex (Posición 3) - CORREGIDO
                linea.setColorHex(fila[3] != null ? fila[3].toString() : "#000000");

                // Sentido (Posición 4)
                linea.setSentido(fila[4] != null ? fila[4].toString() : "N/A");

                // Geometría ST_AsText (Posición 5)
                linea.setGeom(fila[5] != null ? fila[5].toString() : null);

                lineas.add(linea);

            } catch (Exception e) {
                System.err.println("Error procesando fila: " + e.getMessage());
            }
        }
        return lineas;
    }
}