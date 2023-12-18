package com.cocode.service.impl;

import com.cocode.model.dto.UsuarioDto;
import com.cocode.model.entity.Usuario;
import com.cocode.model.repository.UsuarioRepository;
import com.cocode.service.IUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService implements IUsuario {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public List<Usuario> listAll() {
        return (List<Usuario>) usuarioRepository.findAll();
    }

    @Override
    public Usuario save(UsuarioDto usuarioDto) {

        Usuario usuario = Usuario.builder()
                .id(usuarioDto.getId())
                .nombre(usuarioDto.getNombre())
                .apellido(usuarioDto.getApellido())
                .email(usuarioDto.getEmail())
                .password(usuarioDto.getPassword())
                .pais(usuarioDto.getPais())
                .descripcion(usuarioDto.getDescripcion())
                .rol(usuarioDto.getRol())
                .avatar(usuarioDto.getAvatar())
                .puntos(usuarioDto.getPuntos())
                .colaboradores(usuarioDto.getColaboradores())
                .tecnologias(usuarioDto.getTecnologias())
                .proyectos(usuarioDto.getProyectos())
                .proyectosFavoritos(usuarioDto.getProyectosFavoritos())
                .build();

        return usuarioRepository.save(usuario);
    }

    @Override
    public Usuario findById(Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(Usuario usuario) {

        usuarioRepository.delete(usuario);

    }

    @Override
    public boolean existById(Long id) {
        return usuarioRepository.existsById(id);
    }
}
