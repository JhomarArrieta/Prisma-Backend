package com.talentotech.prisma.backend.services.Impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import com.talentotech.prisma.backend.dto.PerfilDTO;
import com.talentotech.prisma.backend.entities.Perfil;
import com.talentotech.prisma.backend.repositories.PerfilDao;
import com.talentotech.prisma.backend.services.PerfilService;
public class PerfilServiceImpl implements PerfilService{

    @Autowired
    private PerfilDao perfilDao; 

    public Perfil convertToEntity(PerfilDTO perfilDTO){
        Perfil perfil = new Perfil();
        perfil.setDescripcion(perfilDTO.getDescripcion());
        perfil.setFoto(perfilDTO.getFoto());
        perfil.setGustos(perfilDTO.getGustos());
        perfil.setId_usuario(perfilDTO.getId_usuario());
        return perfil;
    }

    public PerfilDTO convertToDTO(Perfil perfil){
        PerfilDTO perfilDto = new PerfilDTO();
        perfilDto.setDescripcion(perfil.getDescripcion());
        perfilDto.setFoto(perfil.getFoto());
        perfilDto.setGustos(perfil.getGustos());
        perfilDto.setId_usuario(perfil.getId_usuario());
        return perfilDto;
    }

    @Override
    public PerfilDTO guardarPerfil(PerfilDTO perfilDTO) {
        Perfil perfil = convertToEntity(perfilDTO);
        Perfil guardado = perfilDao.save(perfil);
        return convertToDTO(guardado);
    }

    @Override
    public PerfilDTO actualizarPerfil(PerfilDTO perfilDTO) {
        Optional<Perfil> perfilExistente = perfilDao.findById(perfilDTO.getId_usuario());
        if(perfilExistente.isPresent()){
            Perfil perfil = perfilExistente.get();

        if(perfilDTO.getDescripcion()!=null){
            perfil.setDescripcion(perfilDTO.getDescripcion());
        }
        if(perfilDTO.getGustos()!=null){
            perfil.setGustos(perfilDTO.getGustos());
        }

        Perfil perfilActualizado = perfilDao.save(perfil);
        return convertToDTO(perfilActualizado);
        }
        return null;
    }
}
