package com.talentotech.prisma.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import com.talentotech.prisma.backend.services.UsuarioService;

//import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.talentotech.prisma.backend.dto.UsuarioDTO;

//@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/usuario")
public class UsuarioController{
    
    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public UsuarioDTO ingresarUsuario(@RequestBody UsuarioDTO usuario) {
        System.out.println("fecha de nacimiento: " + usuario.getFecha_nacimiento());
        return usuarioService.crearUsuario(usuario);
    }

    @PostMapping("/{id_preferencias}/agregar/{id_usuario}")
    public ResponseEntity<Void> personalizarUsuario(@PathVariable long id_preferencias, @PathVariable long id_usuario) {
        usuarioService.ingresarPreferencias(id_preferencias, id_usuario);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    

}