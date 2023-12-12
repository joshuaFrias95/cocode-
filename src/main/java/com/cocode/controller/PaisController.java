package com.cocode.controller;

import com.cocode.model.dto.PaisDto;
import com.cocode.model.entity.Pais;
import com.cocode.model.payload.ResponseMessage;
import com.cocode.service.IPais;
import org.aspectj.bridge.IMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.http.HttpResponse;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class PaisController {
    @Autowired
    private IPais paisServicio;

    @GetMapping("paises")
    public ResponseEntity<?> showAll() {
        List<Pais>  getList = paisServicio.listAll();

        if (getList == null) {
            return new ResponseEntity<>(ResponseMessage.builder().message("No se econtraron paises").object(null).build(), HttpStatus.OK);
        }

        return new ResponseEntity<>(ResponseMessage.builder().message("Lista paises:").object(getList).build(), HttpStatus.OK);
    }

    @GetMapping("pais/{id}")
    public ResponseEntity<?> showById(@PathVariable Long id) {
        Pais pais = paisServicio.findById(id);

        if (pais == null) {
            return new ResponseEntity<>(ResponseMessage.builder().message("El registro que estás buscando no ha podido ser encontrad").object(null).build(), HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(ResponseMessage.builder().message("").object(
                PaisDto.builder().id(pais.getId())
                        .codigo_pais(pais.getCodigo_pais())
                        .nombre(pais.getNombre())
                        .build()
        ).build(), HttpStatus.OK);
    }
}
