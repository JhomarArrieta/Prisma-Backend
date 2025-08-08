package com.talentotech.prisma.backend.dto;

import com.talentotech.prisma.backend.entities.Match;
import com.talentotech.prisma.backend.entities.Usuario;

import lombok.Data;

@Data
public class MatchInfoDTO {
    private Long id;
    private Usuario usuarioMatch;
    private Boolean estado;

    public MatchInfoDTO(Match match, Usuario usuarioMatch) {
        this.id = match.getId();
        this.usuarioMatch = usuarioMatch;
        this.estado = match.getEstado();
    }
}