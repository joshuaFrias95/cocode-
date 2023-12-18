package com.cocode.controller;

import com.cocode.model.dto.UsuarioDto;
import com.cocode.model.entity.Usuario;
import com.cocode.config.ResponseMessage;
import com.cocode.service.IUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1")
public class UsuarioController {

    @Autowired
    private IUsuario usuarioService;

    @CrossOrigin
    @GetMapping("usuarios")
    public ResponseEntity<?> showAll() {

        List<Usuario> getList = usuarioService.listAll();

        if (getList == null) {

            return  new ResponseEntity<>(
                    ResponseMessage.builder()
                            .message("No hay registros").object(null)
                            .build(), HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(
                ResponseMessage.builder()
                        .message("").object(getList)
                        .build(), HttpStatus.OK);
    }



    @CrossOrigin
    @PostMapping("usuario")
    public ResponseEntity<?> create(@RequestBody UsuarioDto usuarioDto) {

        Usuario usuarioSave = null;

        try {

            usuarioSave = usuarioService.save(usuarioDto);

            return new ResponseEntity<>(
                    ResponseMessage.builder().message("").object(UsuarioDto.builder()
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
                                    .proyectosFavoritos(usuarioDto.getProyectosFavoritos()).build())
                            .build(), HttpStatus.CREATED);


        } catch (DataAccessException exDA) {

            return new ResponseEntity<>(ResponseMessage.builder().message(exDA.getMessage())
                    .object(null).build(), HttpStatus.METHOD_NOT_ALLOWED);
        }
    }


    @CrossOrigin
    @GetMapping("usuario/{id}")
    public ResponseEntity<?> showById(@PathVariable Long id) {

        Usuario usuario = usuarioService.findById(id);

        if (usuario == null) {

            return new ResponseEntity<>(
                    ResponseMessage.builder()
                            .message("El registro que intentas buscar no existe").object(null)
                            .build(), HttpStatus.NOT_FOUND
            );
        }

        return new ResponseEntity<>(
                ResponseMessage.builder().message("").object(UsuarioDto.builder()
                        .id(usuario.getId())
                        .nombre(usuario.getNombre())
                        .apellido(usuario.getApellido())
                        .email(usuario.getEmail())
                        .password(usuario.getPassword())
                        .pais(usuario.getPais())
                        .descripcion(usuario.getDescripcion())
                        .rol(usuario.getRol())
                        .avatar(usuario.getAvatar())
                        .puntos(usuario.getPuntos())
                        .colaboradores(usuario.getColaboradores())
                        .tecnologias(usuario.getTecnologias())
                        .proyectos(usuario.getProyectos())
                        .proyectosFavoritos(usuario.getProyectosFavoritos()).build())
                        .build(), HttpStatus.OK);

    }



    @CrossOrigin
    @DeleteMapping("usuario/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {

        Usuario usuarioDelete = null;

        try {

            usuarioDelete = usuarioService.findById(id);
            usuarioService.delete(usuarioDelete);

            return new ResponseEntity<>(usuarioDelete, HttpStatus.NO_CONTENT);

        } catch (DataAccessException exDA) {

            return new ResponseEntity<>(ResponseMessage.builder()
                    .message(exDA.getMessage())
                    .object(null)
                    .build(), HttpStatus.METHOD_NOT_ALLOWED);

        }
    }
}
