package com.talentotech.prisma.backend.services.Impl;

import java.util.List;
import java.util.stream.Collectors;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.talentotech.prisma.backend.dto.MatchInfoDTO;
import com.talentotech.prisma.backend.entities.Match;
import com.talentotech.prisma.backend.entities.Usuario;
import com.talentotech.prisma.backend.repositories.MatchRepository;
import com.talentotech.prisma.backend.repositories.UsuarioDao;
import com.talentotech.prisma.backend.services.MatchService;

@Service
public class MatchServiceImpl implements MatchService{
    
    private final MatchRepository matchRepository;
    private final UsuarioDao usuarioDao;

    public MatchServiceImpl(MatchRepository matchRepository, UsuarioDao usuarioDao) {
        this.matchRepository = matchRepository;
        this.usuarioDao = usuarioDao;
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
    public List<MatchInfoDTO> obtenerMatchesPorPersona(Long idPersona) {

        List<Match> matches = matchRepository.findByIdPersona1OrIdPersona2(idPersona, idPersona);
        return matches.stream().map(match -> {
            Long idPersonaMatch = (match.getIdPersona1().equals(idPersona)) ? match.getIdPersona2() : match.getIdPersona1();
            Optional<Usuario> usuarioMatchOptional = usuarioDao.findById(idPersonaMatch);
            return usuarioMatchOptional.map(usuarioMatch -> new MatchInfoDTO(match, usuarioMatch)).orElse(null);
        }).filter(java.util.Objects::nonNull).collect(Collectors.toList());
    }
}
