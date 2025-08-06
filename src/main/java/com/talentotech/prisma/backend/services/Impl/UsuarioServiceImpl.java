package com.talentotech.prisma.backend.services.Impl;

import java.util.Optional;
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

    @Autowired
    private PreferenciasDao preferenciasDao;
    
    public PreferenciasDTO convertToDTOP(Preferencias preferencias){
        PreferenciasDTO preferenciasDTO = new PreferenciasDTO();
        preferenciasDTO.setDiferencia_edad(preferencias.getDiferencia_edad());
        preferenciasDTO.setHijos(preferencias.getHijos());
        preferenciasDTO.setTipo_relacion(preferencias.getTipo_relacion());
        return preferenciasDTO;
    }

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

    public Preferencias convertToEntityP(PreferenciasDTO preferenciasDTO){
        Preferencias preferencias = new Preferencias();
        preferencias.setDiferencia_edad(preferenciasDTO.getDiferencia_edad());
        preferencias.setHijos(preferenciasDTO.getHijos());
        preferencias.setTipo_relacion(preferenciasDTO.getTipo_relacion());
        return preferencias;
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
    public void ingresarPreferencias(long id_preferencias, long id_usuario) {
        Usuario usuario = usuarioDao.findById(id_usuario)
            .orElseThrow(() -> new RuntimeException( "Usuario con id "+ id_usuario + " no fue encontrado."));
        Preferencias preferencias = preferenciasDao.findById(id_preferencias)
            .orElseThrow(() -> new RuntimeException("Preferencias con id "+ id_preferencias + " no fueron encontradas."));

        usuario.getPreferencias().add(preferencias);
        preferencias.getUsuarios().add(usuario);
        preferenciasDao.ingresarPreferencias(id_preferencias, id_usuario);
    }

    @Override
    public Optional<Usuario> findById(long id) {
        return usuarioDao.findById(id);
    }

}   