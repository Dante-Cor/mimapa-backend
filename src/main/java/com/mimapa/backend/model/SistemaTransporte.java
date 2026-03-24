package com.mimapa.backend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "sistemas_transporte")
public class SistemaTransporte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_sistema")
    private Integer idSistema;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "tipo")
    private String tipo;

    // Constructor vacío (Obligatorio para que Hibernate haga su magia)
    public SistemaTransporte() {
    }

    // --- GETTERS Y SETTERS ---
    // (Estos métodos le permiten a Java leer y escribir los datos de forma segura)

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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
