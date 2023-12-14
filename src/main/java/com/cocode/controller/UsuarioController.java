package com.cocode.controller;

import com.cocode.model.dao.UsuarioDao;
import com.cocode.model.dto.UsuarioDto;
import com.cocode.model.entity.Usuario;
import com.cocode.model.payload.ResponseMessage;
import com.cocode.service.IUsuarioService;
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
    private IUsuarioService usuarioService;

    @GetMapping("usuarios")
    public ResponseEntity<?> showAll() {
        List<Usuario> getList = usuarioService.listAll();

        if (getList == null) {
            return new ResponseEntity<>(
                    ResponseMessage.builder()
                            .message("No hay registros")
                            .object(null)
                            .build()
                    , HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(
                ResponseMessage.builder()
                        .message("")
                        .object(getList)
                        .build()
                , HttpStatus.OK);
    }

    @GetMapping("usuario/{id}")
    public ResponseEntity<?> showById(@PathVariable Long id) {
        Usuario usuario = usuarioService.findById(id);

        if (usuario == null) {

            return new ResponseEntity<>(
                    ResponseMessage.builder()
                            .message("El registro que intentas buscar no existe")
                            .object(null)
                            .build(), HttpStatus.NOT_FOUND
            );
        }

        return new ResponseEntity<>(
                ResponseMessage.builder()
                        .message("").object(UsuarioDto.builder()
                                .id(usuario.getId())
                                .nombre(usuario.getNombre())
                                .apellido(usuario.getApellido())
                                .email(usuario.getEmail())
                                .password(usuario.getPassword())
                                .pais(usuario.getPais())
                                .descripcion(usuario.getDescripcion())
                                .puesto(usuario.getPuesto())
                                .avatar(usuario.getAvatar())
                                .puntos(usuario.getPuntos())
                                .activo(usuario.getActivo()).build())
                        .build(), HttpStatus.OK
        );
    }

    @PostMapping("usuario")
    public ResponseEntity<?> create(@RequestBody UsuarioDto usuarioDto) {
        Usuario usuarioSave = null;

        try {
            usuarioSave = usuarioService.save(usuarioDto);

            return new ResponseEntity<>(ResponseMessage.builder()
                    .message("Usuario registrado correctamente")
                    .object(UsuarioDto.builder()
                            .id(usuarioDto.getId())
                            .nombre(usuarioDto.getNombre())
                            .apellido(usuarioDto.getApellido())
                            .email(usuarioDto.getEmail())
                            .password(usuarioDto.getPassword())
                            .pais(usuarioDto.getPais())
                            .descripcion(usuarioDto.getDescripcion())
                            .puesto(usuarioDto.getPuesto())
                            .avatar(usuarioDto.getAvatar())
                            .puntos(usuarioDto.getPuntos())
                            .activo(usuarioDto.getActivo()).build())
                    .build(), HttpStatus.CREATED);
        } catch (DataAccessException exDA) {

            return new ResponseEntity<>(ResponseMessage.builder().message(exDA.getMessage())
                    .object(null).build(), HttpStatus.METHOD_NOT_ALLOWED);
        }
    }

    @PutMapping("cliente/{id}")
    public ResponseEntity<?> update(@RequestBody UsuarioDto usuarioDto, @PathVariable Long id) {
        Usuario usuarioUpdate = null;

        try {

            if (usuarioService.existById(id)) {
                usuarioDto.setId(id);
                usuarioUpdate = usuarioService.save(usuarioDto);

                return new ResponseEntity<>(ResponseMessage.builder()
                        .message("Usuario actualizado correctamente")
                        .object(UsuarioDto.builder()
                                .id(usuarioDto.getId())
                                .nombre(usuarioDto.getNombre())
                                .apellido(usuarioDto.getApellido())
                                .email(usuarioDto.getEmail())
                                .password(usuarioDto.getPassword())
                                .pais(usuarioDto.getPais())
                                .descripcion(usuarioDto.getDescripcion())
                                .puesto(usuarioDto.getPuesto())
                                .avatar(usuarioDto.getAvatar())
                                .puntos(usuarioDto.getPuntos())
                                .activo(usuarioDto.getActivo()).build()).build(), HttpStatus.CREATED);
            } else {
                return new ResponseEntity<>(
                        ResponseMessage.builder()
                                .message("El registro que intentas actualizar no ha podido ser encontrado")
                                .object(null)
                                .build(), HttpStatus.NOT_FOUND
                );
            }

        } catch (DataAccessException exDa) {

            return new ResponseEntity<>(
                    ResponseMessage.builder()
                            .message(exDa.getMessage())
                            .object(null)
                            .build(), HttpStatus.METHOD_NOT_ALLOWED
            );
        }
    }
}










