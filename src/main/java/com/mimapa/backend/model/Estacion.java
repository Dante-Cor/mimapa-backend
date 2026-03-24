package com.mimapa.backend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "estaciones")
public class Estacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_estacion") // Apunta al nombre real en la BD
    private Integer id;

    private String nombre;

    @Column(name = "codigo_slug")
    private String codigoSlug;

    private String tipo;

    private String nivel;

    private String municipio;

    @Column(name = "estatus_operativo")
    private String estatusOperativo;

    public Estacion() {
    }

    // --- Getters y Setters ---
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getCodigoSlug() { return codigoSlug; }
    public void setCodigoSlug(String codigoSlug) { this.codigoSlug = codigoSlug; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public String getNivel() { return nivel; }
    public void setNivel(String nivel) { this.nivel = nivel; }

    public String getMunicipio() { return municipio; }
    public void setMunicipio(String municipio) { this.municipio = municipio; }

    public String getEstatusOperativo() { return estatusOperativo; }
    public void setEstatusOperativo(String estatusOperativo) { this.estatusOperativo = estatusOperativo; }
}