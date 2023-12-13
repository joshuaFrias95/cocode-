package com.cocode.controller;

import com.cocode.model.entity.RolProyecto;
import com.cocode.model.entity.RolProyectoDto;
import com.cocode.model.payload.ResponseMessage;
import com.cocode.service.IRolProyecto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class RolProyectoController {

    @Autowired
    private IRolProyecto rolProyectoService;

    @GetMapping("rolesproyecto")
    public ResponseEntity<?> showAll() {
        List<RolProyecto> getList = rolProyectoService.listAll();

        if (getList == null) {
            return new ResponseEntity<>(ResponseMessage.builder().message("No se encontró ningún elemento")
                    .object(null).build(), HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(ResponseMessage.builder().message("")
                .object(getList).build(), HttpStatus.OK);
    }


    @GetMapping("rolproyecto/{id}")
    public ResponseEntity<?> showById(@PathVariable Long id) {
        RolProyecto rolProyecto = rolProyectoService.findById(id);

        if (rolProyecto == null) {
            return new ResponseEntity<>(ResponseMessage.builder().message("El registro que estás buscando no ha podido ser encontrado")
                    .object(null).build(), HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(ResponseMessage.builder().message("").object(
                RolProyectoDto.builder()
                        .id(rolProyecto.getId())
                        .nombre(rolProyecto.getNombre())
        ).build(), HttpStatus.OK);
    }

}
