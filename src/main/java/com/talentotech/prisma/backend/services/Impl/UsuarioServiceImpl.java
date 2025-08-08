package com.talentotech.prisma.backend.services.Impl;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.talentotech.prisma.backend.dto.PreferenciasDTO;
import com.talentotech.prisma.backend.dto.UserCompleted;
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

    @Autowired
    private PasswordEncoder passwordEncoder;
    
    public PreferenciasDTO convertToDTOP(Preferencias preferencias){
        PreferenciasDTO preferenciasDTO = new PreferenciasDTO();
        preferenciasDTO.setId(preferencias.getId());
        preferenciasDTO.setDiferencia_edad(preferencias.getDiferencia_edad());
        preferenciasDTO.setHijos(preferencias.getHijos());
        preferenciasDTO.setTipo_relacion(preferencias.getTipo_relacion());
        return preferenciasDTO;
    }

    public static UsuarioDTO convertToDTO(Usuario usuario){
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.setId(usuario.getId());
        usuarioDTO.setPrimer_nombre(usuario.getPrimer_nombre());
        usuarioDTO.setSegundo_nombre(usuario.getSegundo_nombre());
        usuarioDTO.setPrimer_apellido(usuario.getPrimer_apellido());
        usuarioDTO.setSegundo_apellido(usuario.getSegundo_apellido());
        usuarioDTO.setUbicacion(usuario.getUbicacion());
        usuarioDTO.setFecha_nacimiento(usuario.getFecha_nacimiento());
        usuarioDTO.setEmail(usuario.getEmail());
        usuarioDTO.setContrasena(null);
        usuarioDTO.setAdministrador(usuario.getAdministrador());
        return usuarioDTO;
    }

    public Preferencias convertToEntityP(PreferenciasDTO preferenciasDTO){
        Preferencias preferencias = new Preferencias();
        preferencias.setId(preferenciasDTO.getId());
        preferencias.setDiferencia_edad(preferenciasDTO.getDiferencia_edad());
        preferencias.setHijos(preferenciasDTO.getHijos());
        preferencias.setTipo_relacion(preferenciasDTO.getTipo_relacion());
        return preferencias;
    }

    public static Usuario convertToEntity(UsuarioDTO usuarioDTO){
        Usuario usuario = new Usuario();
        usuario.setId(usuarioDTO.getId());
        usuario.setPrimer_nombre(usuarioDTO.getPrimer_nombre());
        usuario.setSegundo_nombre(usuarioDTO.getSegundo_nombre());
        usuario.setPrimer_apellido(usuarioDTO.getPrimer_apellido());
        usuario.setSegundo_apellido(usuarioDTO.getSegundo_apellido());
        usuario.setUbicacion(usuarioDTO.getUbicacion());
        usuario.setFecha_nacimiento(usuarioDTO.getFecha_nacimiento());
        usuario.setEmail(usuarioDTO.getEmail());
        usuario.setContrasena(usuarioDTO.getContrasena());
        usuario.setAdministrador(usuarioDTO.getAdministrador());
        return usuario;
    }

    @Override
    public UsuarioDTO crearUsuario(UsuarioDTO usuarioDTO) {
        if (obtenerUsuarioPorEmail(usuarioDTO.getEmail()).isPresent()){
            throw new UnsupportedOperationException("El usuario ya existe.");
        } else {
            Usuario usuarioEntidad = convertToEntity(usuarioDTO);
            if(usuarioEntidad.getContrasena() != null && !usuarioEntidad.getContrasena().isEmpty()){
                usuarioEntidad.setContrasena(passwordEncoder.encode(usuarioEntidad.getContrasena()));
                Usuario guardado = usuarioDao.save(usuarioEntidad);
                return convertToDTO(guardado);
            } else {
                throw new UnsupportedOperationException("El campo de la contraseña está vacío.");
            }
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

    @Override
    public UsuarioDTO verificarUsuario(String email, String contrasena) {
        if (obtenerUsuarioPorEmail(email).isPresent()){
            Usuario usuario = usuarioDao.findUsuarioByEmail(email);
            if (passwordEncoder.matches(contrasena, usuario.getContrasena())){
                return convertToDTO(usuario);
            } else {
                throw new UnsupportedOperationException("La contraseña es incorrecta.");
            }
        } else {
            throw new UnsupportedOperationException("El usuario no existe.");
        }
    }

    @Override
    public void ingresarCandidatos(long id_interesado, long id_candidato) {
        Usuario usuario1 = usuarioDao.findById(id_interesado)
            .orElseThrow(() -> new RuntimeException("El interesado no existe"));
        Usuario usuario2 = usuarioDao.findById(id_candidato)
            .orElseThrow(() -> new RuntimeException("El candidato no existe"));

        usuario1.getCandidatos().add(usuario2);
        usuarioDao.ingresarPreferencias(id_interesado, id_candidato);
    }

    @Override
    public Set<UsuarioDTO> obtenerCandidatos(long id_interesado) {
        Usuario usuario = usuarioDao.findById(id_interesado)
            .orElseThrow(() -> new RuntimeException("No existe el usuario."));

        Set<UsuarioDTO> candidatosListos = new HashSet<>();
        for(Usuario user : usuario.getCandidatos()){
            candidatosListos.add(convertToDTO(user));
        }
        return candidatosListos;
    }

    public PreferenciasDTO findPreferenciasByUsuario(long id_usuario) {
        return convertToDTOP(preferenciasDao.findPreferenciasByUsuario(id_usuario));
    }

    @Override
    public void filtrar(long id_usuario) {
        Usuario usuarioC = usuarioDao.findById(id_usuario)
            .orElseThrow(() -> new RuntimeException("El usuario no existe"));
        PreferenciasDTO preferenciasInteresado = findPreferenciasByUsuario(id_usuario);
        List<Usuario> usuarios = usuarioDao.findAll();
        for(Usuario usuario : usuarios){
            PreferenciasDTO preferencias = findPreferenciasByUsuario(usuario.getId());
            if (preferenciasInteresado.getDiferencia_edad()==preferencias.getDiferencia_edad()
            || preferenciasInteresado.getHijos().equals(preferencias.getHijos())
            || preferenciasInteresado.getTipo_relacion().equals(preferencias.getTipo_relacion())){
                ingresarCandidatos(id_usuario, usuario.getId()); 
            }
            
        }

    }

    @Override
    public Set<UserCompleted> obtenerInformacionCandidatos(Set<UsuarioDTO> candidatos) {
        Set<UserCompleted> informacionUsuarios = new HashSet<>();
        for (UsuarioDTO usuarioDTO : candidatos){
            UserCompleted usuarioCompleted = new UserCompleted();
            if(usuarioDTO.getPrimer_nombre() != null){
                usuarioCompleted.setPrimer_nombre(usuarioDTO.getPrimer_nombre());
            }

            if(usuarioDTO.getPrimer_apellido() != null){
                usuarioCompleted.setPrimer_apellido(usuarioDTO.getPrimer_apellido());
            }
            
            if(usuarioDTO.getUbicacion()!=null){
                usuarioCompleted.setUbicacion(usuarioDTO.getUbicacion());
            }
            if(findPreferenciasByUsuario(usuarioDTO.getId()).getTipo_relacion() != null){
                usuarioCompleted.setTipo_relacion(findPreferenciasByUsuario(usuarioDTO.getId()).getTipo_relacion());
            }

            informacionUsuarios.add(usuarioCompleted);
        }

        return informacionUsuarios;
    }

    

    

    

}   