package com.yoprogramo.ddback.dto.response;

public class BaseResponse {
    private Integer statusCode;
    public BaseResponse(){}

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }
}
