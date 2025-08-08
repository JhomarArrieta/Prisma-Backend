package com.talentotech.prisma.backend.repositories;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.talentotech.prisma.backend.entities.Usuario;

import jakarta.transaction.Transactional;

@Repository
public interface UsuarioDao extends JpaRepository<Usuario, Long>{
    Optional<Usuario> findByEmail(String email);
    Usuario findUsuarioByEmail(String email);

    // @Query("SELECT m FROM Usuario m JOIN m.usuarios a WHERE a.id = :id_interesado")
    // List<Usuario> findCandidatos(@Param("id_interesado") long id_interesado);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO candidatos (id_interesado, id_candidato) VALUES (:id_interesado, :id_candidato)", nativeQuery = true)
    void ingresarPreferencias(@Param("id_interesado") long id_interesado, @Param("id_candidato") long id_candidato);

}