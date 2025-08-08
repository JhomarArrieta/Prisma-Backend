package com.talentotech.prisma.backend.dto;

public class AuthResponse {
    private String token;
    private String email;
    private Boolean isAdmin;
    private String tokenType = "Bearer";

    public AuthResponse() {
    }

    public AuthResponse(String token, String email, Boolean isAdmin) {
        this.token = token;
        this.email = email;
        this.isAdmin = isAdmin;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUsername() {
        return email;
    }

    public void setUsername(String email) {
        this.email = email;
    }

    public Boolean getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(Boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    @Override
    public String toString() {
        return "AuthResponse{" +
                "email='" + email + '\'' +
                ", isAdmin=" + isAdmin +
                ", tokenType='" + tokenType + '\'' +
                '}';
    }
}
