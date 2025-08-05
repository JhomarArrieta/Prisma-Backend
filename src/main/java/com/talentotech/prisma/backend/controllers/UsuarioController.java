package com.talentotech.prisma.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.talentotech.prisma.backend.services.UsuarioService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.talentotech.prisma.backend.dto.UsuarioDTO;


@RestController
public class UsuarioController{
    
    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/usuario")
    public UsuarioDTO postMethodName(@RequestBody UsuarioDTO usuario) {
        return usuarioService.crearUsuario(usuario);
    }

}