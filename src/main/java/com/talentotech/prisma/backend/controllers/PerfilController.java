package com.talentotech.prisma.backend.controllers;

import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.talentotech.prisma.backend.dto.PerfilDTO;
import com.talentotech.prisma.backend.services.PerfilService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class PerfilController {
    
    @Autowired
    private PerfilService perfilService;

    @PostMapping("/perfil")
    public ResponseEntity<PerfilDTO> guardarPerfil(
        @RequestParam("id_usuario") long id_usuario,
        @RequestParam("descripcion") String descripcion,
        @RequestParam("foto") MultipartFile foto,
        @RequestParam("gustos") List<String> gustos) throws IOException {
        
            PerfilDTO perfilDTO = new PerfilDTO();
            perfilDTO.setId_usuario(id_usuario);
            perfilDTO.setDescripcion(descripcion);
            perfilDTO.setFoto(foto.getBytes());
            perfilDTO.setGustos(gustos);

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
