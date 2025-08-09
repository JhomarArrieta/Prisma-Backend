package com.talentotech.prisma.backend.services;

import com.talentotech.prisma.backend.dto.PerfilDTO;

public interface PerfilService {

    PerfilDTO guardarPerfil(PerfilDTO perfilDTO);  
    PerfilDTO actualizarPerfil(PerfilDTO perfilDTO); 
    PerfilDTO encontrarPerfil(long id); 
}
