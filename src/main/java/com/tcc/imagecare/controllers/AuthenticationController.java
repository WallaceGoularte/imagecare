package com.tcc.imagecare.controllers;

import com.tcc.imagecare.models.dto.UsuarioDTO;
import com.tcc.imagecare.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {

    @Autowired
    private UsuarioService service;

    @PostMapping("/login")
    public boolean checkLogin(@RequestBody UsuarioDTO usuarioDTO) {
        return service.autenticar(usuarioDTO);
    }
}
