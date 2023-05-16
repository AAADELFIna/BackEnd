package com.yoprogramo.ddback.dto.request;

public class UpdateHabilidadesRequest {
    private String nombre;
    private Integer calificacion;

    public UpdateHabilidadesRequest(){}


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
