package com.talentotech.prisma.backend.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.talentotech.prisma.backend.entities.Perfil;

public interface PerfilDao extends JpaRepository<Perfil,Long>{
    //Perfil findPerfilById(long id);
    
    @Query("SELECT p FROM Perfil p WHERE p.id_usuario = :id_usuario")
    Optional<Perfil> findPerfilById_usuario(@Param("id_usuario") Long id_usuario);

}
