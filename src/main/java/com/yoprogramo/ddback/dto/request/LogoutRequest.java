package com.yoprogramo.ddback.dto.request;

public class LogoutRequest {
    private String accessToken;
    public LogoutRequest(){}
    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }
}
