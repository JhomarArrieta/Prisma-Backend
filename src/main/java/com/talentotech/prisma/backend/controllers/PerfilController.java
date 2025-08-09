package com.talentotech.prisma.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import com.talentotech.prisma.backend.dto.PerfilDTO;
import com.talentotech.prisma.backend.services.PerfilService;

import jakarta.websocket.server.PathParam;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class PerfilController {
    
    @Autowired
    private PerfilService perfilService;

    @PostMapping("/perfil")
    public ResponseEntity<PerfilDTO> guardarPerfil(@RequestBody PerfilDTO perfilDTO){
        PerfilDTO guardado = perfilService.guardarPerfil(perfilDTO);
        return ResponseEntity.ok(guardado);
    }

    @PutMapping("/perfil/{id}")
    public ResponseEntity<PerfilDTO> actualizarPerfil(@PathVariable String id, @RequestBody PerfilDTO perfilDTO) {
        try{
            PerfilDTO actualizado = perfilService.actualizarPerfil(perfilDTO);
            return ResponseEntity.ok(actualizado);
        } catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("perfil/{id}")
    public ResponseEntity<PerfilDTO> obtenerPerfil(@RequestParam long id) {
        try{
            PerfilDTO perfilDTO = perfilService.encontrarPerfil(id);
            return ResponseEntity.ok(perfilDTO);
        } catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }
    
    
}
