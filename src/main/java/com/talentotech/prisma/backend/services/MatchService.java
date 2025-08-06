package com.talentotech.prisma.backend.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.talentotech.prisma.backend.model.Match;
import com.talentotech.prisma.backend.repository.MatchRepository;

@Service
public class MatchService {
    
    private final MatchRepository matchRepository;

    public MatchService(MatchRepository matchRepository) {
        this.matchRepository = matchRepository;
    }

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

    public List<Match> obtenerMatchesPorPersona(Long idPersona) {
        return matchRepository.findByIdPersona1OrIdPersona2(idPersona, idPersona);
    }

}
