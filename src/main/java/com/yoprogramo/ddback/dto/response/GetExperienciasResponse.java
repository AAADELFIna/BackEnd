package com.yoprogramo.ddback.dto.response;

import com.yoprogramo.ddback.models.Experiencia;

import java.util.List;

public class GetExperienciasResponse extends BaseResponse {
    private List<Experiencia> experiencias;

    public GetExperienciasResponse(){}


    public List<Experiencia> getExperiencias() {
        return experiencias;
    }

    public void setExperiencias(List<Experiencia> experiencias) {
        this.experiencias = experiencias;
    }
}
