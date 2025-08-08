package com.talentotech.prisma.backend.controllers;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import com.talentotech.prisma.backend.services.UsuarioService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.talentotech.prisma.backend.dto.AuthResponse;
import com.talentotech.prisma.backend.dto.Login;
import com.talentotech.prisma.backend.dto.UserCompleted;
import com.talentotech.prisma.backend.dto.UsuarioDTO;
import com.talentotech.prisma.backend.security.JwtUtil;

//@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/usuario")
public class UsuarioController{
    
    @Autowired
    private UsuarioService usuarioService;
    
    @Autowired
    private JwtUtil jwtUtil;

        @PostMapping
        public UsuarioDTO ingresarUsuario(@RequestBody UsuarioDTO usuario) {
            return usuarioService.crearUsuario(usuario);
        }

        @PostMapping("/{id_preferencias}/agregar/{id_usuario}")
        public ResponseEntity<Void> personalizarUsuario(@PathVariable long id_preferencias, @PathVariable long id_usuario) {
            usuarioService.ingresarPreferencias(id_preferencias, id_usuario);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }

        @PostMapping("/autenticar")
        public ResponseEntity<AuthResponse> Autenticar(@RequestBody Login userLogin) {
            try{
                if(userLogin.getContrasena() == null || userLogin.getEmail() == null){
                    return ResponseEntity.badRequest().build();
                }

                UsuarioDTO usuarioDTO = usuarioService.verificarUsuario(
                    userLogin.getEmail(), 
                    userLogin.getContrasena()
                );

                if (usuarioDTO!=null){
                    String token = jwtUtil.generateToken(
                        usuarioDTO.getEmail(), 
                        usuarioDTO.getAdministrador()
                        );

                    AuthResponse authResponse = new AuthResponse(
                        token,
                        usuarioDTO.getEmail(),
                        usuarioDTO.getAdministrador()
                    );

                    return ResponseEntity.ok(authResponse);
                } else {
                    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
                }

            } catch (UnsupportedOperationException e) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
            } catch (Exception e){
                e.printStackTrace(); // para ver el error en logs
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }

        }

        @PostMapping("/filtrar/{id_usuario}")
            public ResponseEntity<Void> crearPosiblesMatches(@PathVariable long id_usuario){
            System.out.println("yiuyiuy");
            usuarioService.filtrar(id_usuario);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }

        @GetMapping("/candidatos/{id_usuario}")
        public ResponseEntity<Set<UserCompleted>> obtenerPosiblesMatches(@PathVariable long id_usuario){
            try{
                usuarioService.filtrar(id_usuario);
                Set<UsuarioDTO> candidatos = usuarioService.obtenerCandidatos(id_usuario);
                Set<UserCompleted> info = usuarioService.obtenerInformacionCandidatos(candidatos);
                return ResponseEntity.ok(info);
            } catch (Exception e){
                e.printStackTrace();
                return ResponseEntity.badRequest().build();
        }
    }


    }
