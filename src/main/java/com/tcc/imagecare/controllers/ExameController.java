package com.tcc.imagecare.controllers;

import com.tcc.imagecare.models.TipoExame;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/exame")
public class ExameController {

    @GetMapping("/nomes")
    public ResponseEntity<TipoExame[]> listarAgendamentos() {
        return ResponseEntity.ok(TipoExame.values());
    }
}
