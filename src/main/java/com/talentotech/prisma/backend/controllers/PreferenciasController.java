package com.talentotech.prisma.backend.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import com.talentotech.prisma.backend.dto.PreferenciasDTO;
import com.talentotech.prisma.backend.services.PreferenciasService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/preferencias")
public class PreferenciasController {

    @Autowired
    private PreferenciasService preferenciasService;

    @PostMapping
    public ResponseEntity<PreferenciasDTO> ingresarPreferencias(@Valid @RequestBody PreferenciasDTO preferenciasDTO) {
        PreferenciasDTO guardada = preferenciasService.save(preferenciasDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(guardada);
    }

    @GetMapping("/{id_usuario}/preferencias")
    public ResponseEntity<PreferenciasDTO> getPreferenciasByUsuario(@PathVariable long id) {
        return ResponseEntity.ok(preferenciasService.findPreferenciasByUsuario(id));
    }

    @GetMapping
    public ResponseEntity<List<PreferenciasDTO>> obtenerPreferencias() {
        List<PreferenciasDTO> preferencias = preferenciasService.findAll();
        return ResponseEntity.ok(preferencias);
    }
    
    
}
