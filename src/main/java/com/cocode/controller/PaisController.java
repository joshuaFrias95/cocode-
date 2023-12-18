package com.cocode.controller;

import com.cocode.model.dto.PaisDto;
import com.cocode.model.entity.Pais;
import com.cocode.config.ResponseMessage;
import com.cocode.service.IPais;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class PaisController {

    @Autowired
    private IPais paisService;

    @CrossOrigin
    @GetMapping("paises")
    public ResponseEntity<?> showAll() {

        List<Pais> getList = paisService.listAll();

        if (getList == null) {

            return new ResponseEntity<>(
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
    @GetMapping("pais/{id}")
    public ResponseEntity<?> showById(@PathVariable Long id) {

        Pais pais = paisService.findById(id);

        if (pais == null) {

            return new ResponseEntity<>(
                    ResponseMessage.builder()
                            .message("El registro que intentas buscar no existe").object(null)
                            .build(), HttpStatus.NOT_FOUND
            );
        }

        return new ResponseEntity<>(
                ResponseMessage.builder().message("").object(PaisDto.builder()
                                .id(pais.getId())
                                .codigo(pais.getCodigo())
                                .nombre(pais.getNombre()).build())
                        .build(), HttpStatus.OK);
    }
}
