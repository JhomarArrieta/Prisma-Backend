package com.talentotech.prisma.backend.services.Impl;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.talentotech.prisma.backend.dto.PreferenciasDTO;
import com.talentotech.prisma.backend.entities.Preferencias;
import com.talentotech.prisma.backend.repositories.PreferenciasDao;
import com.talentotech.prisma.backend.services.PreferenciaService;

@Service
public class PreferenciasServiceImpl implements PreferenciaService{

    @Autowired
    public PreferenciasDao preferenciasDao;

    public Preferencias convertToEntityP(PreferenciasDTO preferenciasDTO){
        Preferencias preferencias = new Preferencias();
        preferencias.setId(preferenciasDTO.getId());
        preferencias.setDiferencia_edad(preferenciasDTO.getDiferencia_edad());
        preferencias.setHijos(preferenciasDTO.getHijos());
        preferencias.setTipo_relacion(preferenciasDTO.getTipo_relacion());
        return preferencias;
    }

    public PreferenciasDTO convertToDTOP(Preferencias preferencias){
        PreferenciasDTO preferenciasDTO = new PreferenciasDTO();
        preferenciasDTO.setId(preferencias.getId());
        preferenciasDTO.setDiferencia_edad(preferencias.getDiferencia_edad());
        preferenciasDTO.setHijos(preferencias.getHijos());
        preferenciasDTO.setTipo_relacion(preferencias.getTipo_relacion());
        return preferenciasDTO;
    }

    @Override
    public List<PreferenciasDTO> findAll() {
        return preferenciasDao.findAll().stream()
        .map(this::convertToDTOP)
        .collect(Collectors.toList());
    }

    @Override
    public PreferenciasDTO save(PreferenciasDTO preferenciasDTO) {
        Preferencias preferencias = convertToEntityP(preferenciasDTO);
        Preferencias guardada = preferenciasDao.save(preferencias);
        return convertToDTOP(guardada);
    }

    @Override
    public List<PreferenciasDTO> findPreferenciasByUsuario(long id_usuario) {
        return preferenciasDao.findPreferenciasByUsuario(id_usuario).stream()
            .map(this::convertToDTOP)
            .collect(Collectors.toList());
    }
}
