package com.tcc.imagecare.services;

import com.tcc.imagecare.models.*;
import com.tcc.imagecare.models.dto.AgendamentoDTO;
import com.tcc.imagecare.repositories.AgendamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AgendamentoService {

    private final AgendamentoRepository agendamentoRepository;
    private final ExameService exameService;

    @Autowired
    public AgendamentoService(AgendamentoRepository agendamentoRepository, ExameService exameService) {
        this.agendamentoRepository = agendamentoRepository;
        this.exameService = exameService;
    }

    public List<Agendamento> listarTodosAgendamentosAtivos() {
        List<Agendamento> agendamentos = agendamentoRepository.findAll();

        return agendamentos.stream()
                .filter(agendamento -> agendamento.getData() != null)
                .collect(Collectors.toList());

        //return agendamentoRepository.findAll();
    }

    public Optional<Agendamento> buscarAgendamentoPorId(Integer id) {
        return agendamentoRepository.findById(id);
    }

    public void criarAgendamento(AgendamentoDTO dto) throws Exception {
        Agendamento agendamento = new Agendamento();
        if (dto != null) {
            if (dto.getData() == null) {
                throw new Exception("Foda-se.");
            }

            agendamento.setData(dto.getData());
            agendamento.setStatus(Status.AGENDADO);

            Paciente p = criarPaciente();

            Funcionario f = criarFuncionario();

            Exame e = criarExame(dto);

            agendamento.setPacienteId(p);
            agendamento.setFuncionarioId(f);
            agendamento.setExameId(e);
        }

        agendamentoRepository.save(agendamento);
    }

    private Exame criarExame(AgendamentoDTO dto) {
        Exame e = new Exame();
        e.setNome(TipoExame.fromDescricao(dto.getExame()));
        e.setData(dto.getData());
        exameService.save(e);
        return e;
    }

    private Funcionario criarFuncionario() {
        Funcionario f = new Funcionario();
        f.setId(1);
        return f;
    }

    private Paciente criarPaciente() {
        Paciente p = new Paciente();
        p.setId(1);
        return p;
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
