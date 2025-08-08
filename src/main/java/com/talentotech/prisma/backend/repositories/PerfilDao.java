package com.talentotech.prisma.backend.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.talentotech.prisma.backend.entities.Perfil;

public interface PerfilDao extends JpaRepository<Perfil,Long>{
    //Perfil findPerfilById(long id);
    Optional<Perfil> findPerfilById(long id);
}
