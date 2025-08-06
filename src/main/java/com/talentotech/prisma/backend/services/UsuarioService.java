package com.talentotech.prisma.backend.services;

// import java.util.List;
import java.util.Optional;

// import com.talentotech.prisma.backend.dto.PreferenciasDTO;
import com.talentotech.prisma.backend.dto.UsuarioDTO;
import com.talentotech.prisma.backend.entities.Usuario;

public interface UsuarioService {

    UsuarioDTO crearUsuario(UsuarioDTO usuarioDTO);
    Optional<Usuario> obtenerUsuarioPorEmail(String email);
    // List<PreferenciasDTO> findPreferenciasByUsuario(long id_usuario);
    void ingresarPreferencias(long id_preferencias, long id_usuario);
    Optional<Usuario> findById(long id);
    
}
