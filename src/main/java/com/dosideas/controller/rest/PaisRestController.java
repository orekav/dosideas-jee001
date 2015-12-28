package com.dosideas.controller.rest;

import com.dosideas.domain.Pais;
import com.dosideas.exception.PaisNoEncontradoException;
import com.dosideas.service.PaisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pais")
public class PaisRestController {

    @Autowired
    private PaisService paisService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Pais buscarPorId(@PathVariable Long id) throws PaisNoEncontradoException {
        Pais pais = paisService.buscarPorId(id);
        if (pais == null) {
            throw new PaisNoEncontradoException("Pais no encontrado");
        }
        return pais;
    }
}
