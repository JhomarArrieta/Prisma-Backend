package com.talentotech.prisma.backend.services.Impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.talentotech.prisma.backend.dto.PreferenciasDTO;
import com.talentotech.prisma.backend.dto.UsuarioDTO;
import com.talentotech.prisma.backend.entities.Preferencias;
import com.talentotech.prisma.backend.entities.Usuario;
import com.talentotech.prisma.backend.repositories.PreferenciasDao;
import com.talentotech.prisma.backend.repositories.UsuarioDao;
import com.talentotech.prisma.backend.services.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService{

    @Autowired
    private UsuarioDao usuarioDao;
    private PreferenciasDao preferenciasDao;
    
    public static UsuarioDTO convertToDTO(Usuario usuario){
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.setPrimer_nombre(usuario.getPrimer_nombre());
        usuarioDTO.setSegundo_nombre(usuario.getSegundo_nombre());
        usuarioDTO.setPrimer_apellido(usuario.getPrimer_apellido());
        usuarioDTO.setSegundo_apellido(usuario.getSegundo_apellido());
        usuarioDTO.setUbicacion(usuario.getUbicacion());
        usuarioDTO.setFecha_nacimiento(usuario.getFecha_nacimiento());
        usuarioDTO.setEmail(usuario.getEmail());
        usuarioDTO.setContrasena(usuario.getContrasena());
        usuarioDTO.setAdministrador(usuario.isAdministrador());
        return usuarioDTO;
    }

    public static Usuario convertToEntity(UsuarioDTO usuarioDTO){
        Usuario usuario = new Usuario();
        usuario.setPrimer_nombre(usuarioDTO.getPrimer_nombre());
        usuario.setSegundo_nombre(usuarioDTO.getSegundo_nombre());
        usuario.setPrimer_apellido(usuarioDTO.getPrimer_apellido());
        usuario.setSegundo_apellido(usuarioDTO.getSegundo_apellido());
        usuario.setUbicacion(usuarioDTO.getUbicacion());
        usuario.setFecha_nacimiento(usuario.getFecha_nacimiento());
        usuario.setEmail(usuarioDTO.getEmail());
        usuario.setContrasena(usuarioDTO.getContrasena());
        usuario.setAdministrador(usuario.isAdministrador());
        return usuario;
    }

    @Override
    public UsuarioDTO crearUsuario(UsuarioDTO usuarioDTO) {
        if (obtenerUsuarioPorEmail(usuarioDTO.getEmail()).isPresent()){
            throw new UnsupportedOperationException("El usuario ya existe.");
        } else {
            Usuario usuarioEntidad = convertToEntity(usuarioDTO);
            Usuario guardado = usuarioDao.save(usuarioEntidad);
            return convertToDTO(guardado);
        }
    }

    @Override
    public Optional<Usuario> obtenerUsuarioPorEmail(String email) {
        return usuarioDao.findByEmail(email);
    }

    @Override
    public List<Preferencias> findPreferenciasByUsuario(long id_usuario) {
        return preferenciasDao.findPreferenciasByUsuario(id_usuario).stream()
            .map(this::convertToDTO)
            .collect(Collectors.toList());
    }

    @Override
    public void ingresarPreferencias(int id_preferencias, int id_usuario) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'ingresarPreferencias'");
    }

    @Override
    public Optional<Usuario> findById(long id) {
        return usuarioDao.findById(id);
    }

}   