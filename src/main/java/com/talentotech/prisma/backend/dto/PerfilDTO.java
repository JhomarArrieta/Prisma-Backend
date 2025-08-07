package com.talentotech.prisma.backend.dto;

import java.util.List;

public class PerfilDTO {
    private String descripcion;
    private long id_usuario;
    private byte[] foto;
    private List<String> gustos;

    
    public PerfilDTO() {
    }


    public PerfilDTO(String descripcion, long id_usuario, byte[] foto, List<String> gustos) {
        this.descripcion = descripcion;
        this.id_usuario = id_usuario;
        this.foto = foto;
        this.gustos = gustos;
    }


    public PerfilDTO(String descripcion) {
        this.descripcion = descripcion;
    }


    public PerfilDTO(String descripcion, List<String> gustos) {
        this.descripcion = descripcion;
        this.gustos = gustos;
    }


    public String getDescripcion() {
        return descripcion;
    }


    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


    public long getId_usuario() {
        return id_usuario;
    }


    public void setId_usuario(long id_usuario) {
        this.id_usuario = id_usuario;
    }


    public byte[] getFoto() {
        return foto;
    }


    public void setFoto(byte[] foto) {
        this.foto = foto;
    }


    public List<String> getGustos() {
        return gustos;
    }


    public void setGustos(List<String> gustos) {
        this.gustos = gustos;
    }   

    
}
