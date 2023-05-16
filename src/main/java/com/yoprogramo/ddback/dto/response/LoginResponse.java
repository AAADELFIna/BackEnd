package com.yoprogramo.ddback.dto.response;

public class LoginResponse extends BaseResponse {
    private String accessToken;

    public LoginResponse(){}

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }
}
