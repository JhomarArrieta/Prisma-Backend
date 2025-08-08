package com.talentotech.prisma.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import com.talentotech.prisma.backend.dto.PerfilDTO;
import com.talentotech.prisma.backend.services.PerfilService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class PerfilController {
    
    @Autowired
    private PerfilService perfilService;

    @PostMapping("/perfil")
    public ResponseEntity<PerfilDTO> guardarPerfil(@RequestBody PerfilDTO perfilDTO){
        PerfilDTO guardado = perfilService.guardarPerfil(perfilDTO);
        return ResponseEntity.ok(guardado);
    }

    @PutMapping("perfil/{id}")
    public ResponseEntity<PerfilDTO> actualizarPerfil(@PathVariable String id, @RequestBody PerfilDTO perfilDTO) {
        try{
            PerfilDTO actualizado = perfilService.actualizarPerfil(perfilDTO);
            return ResponseEntity.ok(actualizado);
        } catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }
    
}
