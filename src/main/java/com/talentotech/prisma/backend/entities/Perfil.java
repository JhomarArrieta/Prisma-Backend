package com.talentotech.prisma.backend.entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Size;

@Entity
public class Perfil {
    
    @Id
    @Column(name = "id_usuario")
    private long id_usuario;

    @Size(max = 100)
    @Column(name="descripcion", length = 100)
    private String descripcion;

    @Lob
    @Column(name = "foto")
    private byte[] foto;

    @ElementCollection(fetch = FetchType.EAGER)
    @Column(name = "gustos")
    private List<String> gustos;

    @OneToOne
    @MapsId
    @Column(name="id_usuario")
    private Usuario usuario;

    public Perfil() {
    }

    public Perfil(Long id_usuario, @Size(max = 100) String descripcion, byte[] foto, List<String> gustos,
            Usuario usuario) {
        this.id_usuario = id_usuario;
        this.descripcion = descripcion;
        this.foto = foto;
        this.gustos = gustos;
        this.usuario = usuario;
    }

    public Long getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Long id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    
}
