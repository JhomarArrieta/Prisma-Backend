package com.talentotech.prisma.backend.services.Impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.talentotech.prisma.backend.entities.Match;
import com.talentotech.prisma.backend.repositories.MatchRepository;
import com.talentotech.prisma.backend.services.MatchService;

@Service
public class MatchServiceImpl implements MatchService{
    
    private final MatchRepository matchRepository;

    public MatchServiceImpl(MatchRepository matchRepository) {
        this.matchRepository = matchRepository;
    }

    @Override
    public Match crearLike(Long idPersona1, Long idPersona2) {

        Match matchExistente = matchRepository.findMatchBetween(idPersona1, idPersona2);

        if (matchExistente != null){
            matchExistente.setEstado(true);
            return matchRepository.save(matchExistente);
        }

        Match nuevoMatch = new Match();
        nuevoMatch.setIdPersona1(idPersona1);
        nuevoMatch.setIdPersona2(idPersona2);
        nuevoMatch.setEstado(false);
        return matchRepository.save(nuevoMatch);
    }

    @Override
    public List<Match> obtenerMatchesPorPersona(Long idPersona) {
        return matchRepository.findByIdPersona1OrIdPersona2(idPersona, idPersona);
    }

}
