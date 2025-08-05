package com.talentotech.prisma.backend.repositories;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.talentotech.prisma.backend.entities.Usuario;

@Repository
public interface UsuarioDao extends JpaRepository<Usuario, Long>{
    Optional<Usuario> findByEmail(String email);
}