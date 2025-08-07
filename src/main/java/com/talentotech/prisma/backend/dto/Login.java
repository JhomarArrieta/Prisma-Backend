package com.talentotech.prisma.backend.dto;

public class Login {
    private String contrasena;
    private String email;
    
    public Login() {
    }

    public Login(String contrasena, String email) {
        this.contrasena = contrasena;
        this.email = email;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Login [contrasena=" + contrasena + ", email=" + email + "]";
    }

}
