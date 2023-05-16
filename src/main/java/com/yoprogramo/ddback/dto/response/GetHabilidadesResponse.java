package com.yoprogramo.ddback.dto.response;

import com.yoprogramo.ddback.models.Habilidad;

import java.util.List;

public class GetHabilidadesResponse extends BaseResponse{
    private List<Habilidad> habilidades;

    public GetHabilidadesResponse(){}


    public List<Habilidad> getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(List<Habilidad> habilidades) {
        this.habilidades = habilidades;
    }
}
