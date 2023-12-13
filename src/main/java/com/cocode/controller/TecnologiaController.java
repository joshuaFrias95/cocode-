package com.cocode.controller;

import com.cocode.model.dto.TecnologiaDTO;
import com.cocode.model.entity.Tecnologia;
import com.cocode.model.payload.ResponseMessage;
import com.cocode.service.ITecnologia;
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
public class TecnologiaController {

    @Autowired
    private ITecnologia tecnologiasService;

    @GetMapping("tecnologias")
    public ResponseEntity<?> showAll() {
        List<Tecnologia> getList = tecnologiasService.listAll();

        if (getList == null) {
            return new ResponseEntity<>(ResponseMessage.builder().message("No se encontró ningún elemento")
                    .object(null).build(), HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(ResponseMessage.builder().message("")
                .object(getList).build(), HttpStatus.OK);
    }

    @GetMapping("tecnologias/{id}")
    public ResponseEntity<?> showById(@PathVariable Long id) {
        Tecnologia tecnologia = tecnologiasService.findById(id);

        if (tecnologia == null) {
            return new ResponseEntity<>(ResponseMessage.builder().message("El registro que estás buscando no ha podido ser encontrado")
                    .object(null).build(), HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(ResponseMessage.builder().message("").object(
                TecnologiaDTO.builder()
                        .id(tecnologia.getId())
                        .nombre(tecnologia.getNombre())
                        .build()
        ).build(), HttpStatus.OK);
    }

}
