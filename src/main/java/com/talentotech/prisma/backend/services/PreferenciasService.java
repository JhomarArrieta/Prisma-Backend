package com.talentotech.prisma.backend.services;

import java.util.List;

import com.talentotech.prisma.backend.dto.PreferenciasDTO;

public interface PreferenciasService{

    List<PreferenciasDTO> findAll();
    PreferenciasDTO save(PreferenciasDTO preferenciasDTO);
    List<PreferenciasDTO> findPreferenciasByUsuario(long id_usuario);
}
