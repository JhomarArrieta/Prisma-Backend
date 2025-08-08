package com.talentotech.prisma.backend.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.talentotech.prisma.backend.entities.Preferencias;

import jakarta.transaction.Transactional;

@Repository
public interface PreferenciasDao extends JpaRepository<Preferencias,Long>{

    //List<Preferencias> findByHijos(String hijos);

    //List<Preferencias> findByDiferencia_edad(int diferencia_edad);

    //List<Preferencias> findByTipo_relacion(String tipo_relacion);

    @Query("SELECT m FROM Preferencias m JOIN m.usuarios a WHERE a.id = :id_usuario")
    List<Preferencias> findPreferenciasByUsuario(@Param("id_usuario") long id_usuario);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO preferencias_usuario (id_usuario, id_preferencias) VALUES (:id_usuario, :id_preferencias)", nativeQuery = true)
    void ingresarPreferencias(@Param("id_preferencias") long id_preferencias, @Param("id_usuario") long id_usuario);
}
