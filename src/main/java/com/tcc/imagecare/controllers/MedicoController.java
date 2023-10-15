package com.tcc.imagecare.controllers;

import com.tcc.imagecare.models.Agendamento;
import com.tcc.imagecare.models.HorasAgendamento;
import com.tcc.imagecare.models.Medico;
import com.tcc.imagecare.models.TipoExame;
import com.tcc.imagecare.services.MedicoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/medico")
public class MedicoController {

    private final MedicoService service;

    public MedicoController(MedicoService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Medico>> listarAgendamentos() {
        return ResponseEntity.ok(service.listarMedicos());
    }

    @GetMapping("/horas")
    public ResponseEntity<List<String>> listarHorasDisponiveis() {
        return ResponseEntity.ok(HorasAgendamento.fromHora());
    }

}
