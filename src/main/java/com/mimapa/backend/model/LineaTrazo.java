package com.mimapa.backend.model;

import jakarta.persistence.*;
import org.locationtech.jts.geom.MultiLineString;

@Entity
@Table(name = "lineas_trazos")
public class LineaTrazo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_linea")
    private Integer idLinea;

    @Column(name = "id_sistema")
    private Integer idSistema;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "color_hex")
    private String colorHex;

    @Column(name = "sentido")
    private String sentido;


    @Column(name = "geom", columnDefinition = "geometry")
    private String geom;


    // Constructor vacío
    public LineaTrazo() {
    }

    // --- GETTERS Y SETTERS ---

    public Integer getIdLinea() {
        return idLinea;
    }

    public void setIdLinea(Integer idLinea) {
        this.idLinea = idLinea;
    }

    public Integer getIdSistema() {
        return idSistema;
    }

    public void setIdSistema(Integer idSistema) {
        this.idSistema = idSistema;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getColorHex() {
        return colorHex;
    }

    public void setColorHex(String colorHex) {
        this.colorHex = colorHex;
    }

    public String getSentido() {
        return sentido;
    }

    public void setSentido(String sentido) {
        this.sentido = sentido;
    }

    // Getter para geom
    public String getGeom() {
        return geom;
    }

    // Setter para geom
    public void setGeom(String geom) {
        this.geom = geom;
    }
}