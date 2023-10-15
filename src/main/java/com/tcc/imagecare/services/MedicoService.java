package com.tcc.imagecare.services;

import com.tcc.imagecare.models.Medico;
import com.tcc.imagecare.repositories.MedicoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicoService {

    private final MedicoRepository respotiory;


    public MedicoService(MedicoRepository respotiory) {
        this.respotiory = respotiory;
    }

    public List<Medico> listarMedicos() {
        return respotiory.findAll();
    }

}
