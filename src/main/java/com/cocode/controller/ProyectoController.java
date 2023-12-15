package com.cocode.controller;

import com.cocode.model.entity.Proyecto;
import com.cocode.model.payload.ResponseMessage;
import com.cocode.service.IProyectoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ProyectoController {

    @Autowired
    private IProyectoService proyectoService;

    @GetMapping("proyectos")
    public ResponseEntity<?> showAll() {
        List<Proyecto> getList = proyectoService.listAll();

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
}
