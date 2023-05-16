package com.yoprogramo.ddback.models;

import jakarta.persistence.*;

@Entity
public class Experiencia {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String tipo; //Experiencia laboral, estudios o proyectos
    private String titulo;
    private String organizacion;
    private String periodo;
    @Column(columnDefinition = "TEXT")
    private String descripcion;
    @Column(columnDefinition = "TEXT")
    private String urlImagen;
    private String enlace;

    protected Experiencia(){};
    public Experiencia(String tipo, String titulo, String organizacion, String periodo, String descripcion){
        this.setTipo(tipo);
        this.setTitulo(titulo);
        this.setOrganizacion(organizacion);
        this.setDescripcion(descripcion);
        this.setPeriodo(periodo);
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

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getOrganizacion() {
        return organizacion;
    }

    public void setOrganizacion(String organizacion) {
        this.organizacion = organizacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public String getUrlImagen() {
        return urlImagen;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }

    public String getEnlace() {
        return enlace;
    }

    public void setEnlace(String enlace) {
        this.enlace = enlace;
    }
}
