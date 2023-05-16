package com.yoprogramo.ddback.models;

import jakarta.persistence.*;

@Entity
public class InfoBasica {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String nombre;
    private String cargo;
    @Column(columnDefinition = "TEXT")
    private String acerca;

    protected InfoBasica(){}
    public InfoBasica(String nombre, String cargo, String acerca){
        this.setNombre(nombre);
        this.setCargo(cargo);
        this.setAcerca(acerca);
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getAcerca() {
        return acerca;
    }

    public void setAcerca(String acerca) {
        this.acerca = acerca;
    }
}
