package com.talentotech.prisma.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import com.talentotech.prisma.backend.services.UsuarioService;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.talentotech.prisma.backend.dto.UsuarioDTO;


@RestController
public class UsuarioController{
    
    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/usuario")
    public UsuarioDTO ingresarUsuario(@RequestBody UsuarioDTO usuario) {
        return usuarioService.crearUsuario(usuario);
    }

    @PostMapping("/{id_preferencias}/agregar/{id_usuario}")
    public ResponseEntity<Void> personalizarUsuario(@PathVariable long id_preferencias, @PathVariable long id_usuario) {
        usuarioService.ingresarPreferencias(id_preferencias, id_usuario);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    

}