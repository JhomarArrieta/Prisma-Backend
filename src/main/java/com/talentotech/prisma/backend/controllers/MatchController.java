package com.talentotech.prisma.backend.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.talentotech.prisma.backend.entities.Match;
import com.talentotech.prisma.backend.services.MatchService;

@RestController
public class MatchController {
    
    private final MatchService matchService;

    public MatchController(MatchService matchService) {
        this.matchService = matchService;
    }


    @PostMapping("/matches")
    public Match darLike(@RequestParam Long idPersona1, @RequestParam Long idPersona2) {
        return matchService.crearLike(idPersona1, idPersona2);
    }

    @GetMapping("/matches/persona/{idPersona}")
    public List<Match> obtenerMatchesPorPersona(@PathVariable Long idPersona) {
        return matchService.obtenerMatchesPorPersona(idPersona);
    }
}
