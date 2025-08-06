package com.talentotech.prisma.backend.repository;

import org.springframework.stereotype.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.talentotech.prisma.backend.model.Match;

@Repository
public interface MatchRepository extends JpaRepository<Match, Long> {

    List<Match> findByIdPersona1OrIdPersona2(Long idPersona1, Long idPersona2);

    Match findByIdPersona1AndIdPersona2(Long idPersona1, Long idPersona2);

    @Query("SELECT m FROM Match m WHERE (m.idPersona1 = :id1 AND m.idPersona2 = :id2) OR (m.idPersona1 = :id2 AND m.idPersona2 = :id1)")
    Match findMatchBetween(@Param("id1") Long id1, @Param("id2") Long id2);

}

