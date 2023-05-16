package com.yoprogramo.ddback.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Habilidad {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private String tipo; //dura, blanda o idioma
    private String nombre;
    private Integer calificacion;

    protected Habilidad(){}
    public Habilidad(String tipo, String nombre, Integer calificacion){
        this.setTipo(tipo);
        this.setNombre(nombre);
        this.setCalificacion(calificacion);
    }

    public Long getId() {
        return id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(Integer calificacion) {
        this.calificacion = calificacion;
    }
}
