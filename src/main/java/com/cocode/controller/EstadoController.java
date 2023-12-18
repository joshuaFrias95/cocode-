package com.cocode.controller;

import com.cocode.model.entity.Estado;
import com.cocode.config.ResponseMessage;
import com.cocode.service.IEstado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/api/v1")
public class EstadoController {

    @Autowired
    private IEstado estadoService;

    @CrossOrigin
    @GetMapping("estados")
    public ResponseEntity<?> showAll() {

        List<Estado>  getList = estadoService.listAll();

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
}
