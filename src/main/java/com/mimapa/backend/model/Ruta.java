package com.mimapa.backend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "rutas")
public class Ruta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ruta")
    private Integer idRuta;

    @Column(name = "id_sistema")
    private Integer idSistema;

    private String nombre;
    private String sigla;
    private String subtitulo;

    @Column(name = "color_hex")
    private String colorHex;

    // Getters y Setters
    public Integer getIdRuta() { return idRuta; }
    public void setIdRuta(Integer idRuta) { this.idRuta = idRuta; }

    public Integer getIdSistema() { return idSistema; }
    public void setIdSistema(Integer idSistema) { this.idSistema = idSistema; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getSigla() { return sigla; }
    public void setSigla(String sigla) { this.sigla = sigla; }

    public String getSubtitulo() { return subtitulo; }
    public void setSubtitulo(String subtitulo) { this.subtitulo = subtitulo; }

    public String getColorHex() { return colorHex; }
    public void setColorHex(String colorHex) { this.colorHex = colorHex; }
}