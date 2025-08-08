package com.talentotech.prisma.backend.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.talentotech.prisma.backend.dto.MatchInfoDTO;
import com.talentotech.prisma.backend.entities.Match;

@Service
public interface MatchService {
    Match crearLike(Long idPersona1, Long idPersona2);

    List<MatchInfoDTO> obtenerMatchesPorPersona(Long idPersona);

}

    

