package com.tcc.imagecare.services;

import com.tcc.imagecare.models.Exame;
import com.tcc.imagecare.repositories.ExameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExameService {

    private final ExameRepository exameRepository;

    @Autowired
    public ExameService(ExameRepository exameRepository) {
        this.exameRepository = exameRepository;
    }

    public Exame save(Exame exame) {
        return exameRepository.save(exame);
    }
}
