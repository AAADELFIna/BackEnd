package com.yoprogramo.ddback.dto.response;

import com.yoprogramo.ddback.models.InfoBasica;

public class GetInfoBasicaResponse extends BaseResponse {
    private InfoBasica infoBasica;
    public GetInfoBasicaResponse(){}

    public InfoBasica getInfoBasica() {
        return infoBasica;
    }

    public void setInfoBasica(InfoBasica infoBasica) {
        this.infoBasica = infoBasica;
    }
}
