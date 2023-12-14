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
}










