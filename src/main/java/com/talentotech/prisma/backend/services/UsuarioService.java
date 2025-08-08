package com.talentotech.prisma.backend.services;

// import java.util.List;
import java.util.Optional;
import java.util.Set;

// import com.talentotech.prisma.backend.dto.PreferenciasDTO;
import com.talentotech.prisma.backend.dto.UsuarioDTO;
import com.talentotech.prisma.backend.entities.Usuario;

public interface UsuarioService {

    UsuarioDTO crearUsuario(UsuarioDTO usuarioDTO);
    Optional<Usuario> obtenerUsuarioPorEmail(String email);
    void ingresarPreferencias(long id_preferencias, long id_usuario);
    Optional<Usuario> findById(long id);
    UsuarioDTO verificarUsuario(String email, String correo);
    void ingresarCandidatos(long id_interesado,long id_candidato);
    Set<UsuarioDTO> obtenerCandidatos(long id_interesado);
    void filtrar(long id_usuario);
    Set<UsuarioDTO> obtenerInformacionCandidatos(Set<UsuarioDTO> candidatos);
}
