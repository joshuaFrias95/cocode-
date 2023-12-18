package com.cocode.controller;

import com.cocode.model.dto.DificultadDto;
import com.cocode.model.entity.Dificultad;
import com.cocode.config.ResponseMessage;
import com.cocode.service.IDificultad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class DificultadController {

    @Autowired
    private IDificultad dificultadService;

    @CrossOrigin
    @GetMapping("dificultades")
    public ResponseEntity<?> showAll() {

        List<Dificultad> getList = dificultadService.listAll();

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
    @GetMapping("dificultad/{id}")
    public ResponseEntity<?> showById(@PathVariable Long id) {

        Dificultad dificultad = dificultadService.findById(id);

        if (dificultad == null) {

            return new ResponseEntity<>(
                    ResponseMessage.builder()
                            .message("El registro que intentas buscar no existe").object(null)
                            .build(), HttpStatus.NOT_FOUND
            );
        }

        return new ResponseEntity<>(
                ResponseMessage.builder().message("").object(DificultadDto.builder()
                        .id(dificultad.getId())
                        .nombre(dificultad.getNombre()).build())
                .build(), HttpStatus.OK);
    }
}
