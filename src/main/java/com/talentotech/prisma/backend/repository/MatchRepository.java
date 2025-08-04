package com.talentotech.prisma.backend.repository;

import org.springframework.stereotype.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.talentotech.prisma.backend.model.Match;

@Repository
public interface MatchRepository extends JpaRepository<Match, Long> {

    List<Match> findByIdPersona1OrIdPersona2(Long idPersona1, Long idPersona2);
    Match findByIdPersona1AndIdPersona2(Long idPersona1, Long idPersona2);

}

