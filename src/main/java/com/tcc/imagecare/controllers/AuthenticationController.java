package com.tcc.imagecare.controllers;

import com.tcc.imagecare.models.dto.UsuarioDTO;
import com.tcc.imagecare.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AuthenticationController {

    @Autowired
    private UsuarioService service;

    @PostMapping
    public boolean checkLogin(@RequestBody UsuarioDTO usuarioDTO) {
        return service.autenticar(usuarioDTO);
    }
}
