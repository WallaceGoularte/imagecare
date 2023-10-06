package com.tcc.imagecare.services;

import com.tcc.imagecare.models.Agendamento;
import com.tcc.imagecare.repositories.AgendamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AgendamentoService {

    private final AgendamentoRepository agendamentoRepository;

    @Autowired
    public AgendamentoService(AgendamentoRepository agendamentoRepository) {
        this.agendamentoRepository = agendamentoRepository;
    }

    public List<Agendamento> listarTodosAgendamentos() {
        return agendamentoRepository.findAll();
    }

    public Optional<Agendamento> buscarAgendamentoPorId(Integer id) {
        return agendamentoRepository.findById(id);
    }

    public Agendamento criarAgendamento(Agendamento agendamento) {
        return agendamentoRepository.save(agendamento);
    }

    public Agendamento atualizarAgendamento(Integer id, Agendamento novoAgendamento) {
        if (agendamentoRepository.existsById(id)) {
            novoAgendamento.setId(id);
            return agendamentoRepository.save(novoAgendamento);
        }

        return null;
    }

    public void deletarAgendamento(Integer id) {
        agendamentoRepository.deleteById(id);
    }
}
