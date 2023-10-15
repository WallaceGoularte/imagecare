package com.tcc.imagecare.services;

import com.tcc.imagecare.models.*;
import com.tcc.imagecare.models.dto.AgendamentoDTO;
import com.tcc.imagecare.repositories.AgendamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.TemporalAdjusters;
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
    }

    public List<Agendamento> listarPorDia() {
        var dataAtual = LocalDateTime.now();
        var dataAtualSemHoras = dataAtual.toLocalDate();
        var inicioDoDia = dataAtualSemHoras.atTime(LocalTime.MIN);
        var fimDoDia = dataAtualSemHoras.atTime(LocalTime.MAX);

        return agendamentoRepository.findByDataBetween(inicioDoDia, fimDoDia);
    }

    public List<Agendamento> listarAgendamentoMesAtual() {
        var dataAtual = LocalDateTime.now();
        var dataInicial = LocalDateTime.from(dataAtual.with(TemporalAdjusters.firstDayOfMonth()));
        var dataFinal = dataAtual.with(TemporalAdjusters.lastDayOfMonth());

        return agendamentoRepository.findByDataBetween(dataInicial, dataFinal);
    }

    public List<Agendamento> listarPorSemanaAtual() {
        var dataAtual = LocalDate.now();
        var dataInicial = dataAtual.with(DayOfWeek.MONDAY);
        var dataFinal = dataInicial.plusDays(4);

        var inicioDaSemana = dataInicial.atStartOfDay();
        var fimDaSemana = dataFinal.atTime(23, 59, 59);

        return agendamentoRepository.findByDataBetween(inicioDaSemana, fimDaSemana);
    }

    public Optional<Agendamento> buscarAgendamentoPorId(Integer id) {
        return agendamentoRepository.findById(id);
    }

    public void criarAgendamento(AgendamentoDTO dto) throws Exception {
        Agendamento agendamento = new Agendamento();
        if (dto != null) {
            if (dto.getData() == null) {
                throw new Exception("Data inválida.");
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

    public List<Agendamento> listarPeloAnoAtual() {
        LocalDate dataAtual = LocalDate.now();
        LocalDate inicioDoAno = dataAtual.withDayOfYear(1);
        LocalDate fimDoAno = dataAtual.withDayOfYear(dataAtual.lengthOfYear());

        LocalDateTime inicio = inicioDoAno.atTime(0, 0);
        LocalDateTime fim = fimDoAno.atTime(23, 59, 59);

        return agendamentoRepository.findByDataBetween(inicio, fim);
    }

    public List<Agendamento> buscarAgendamentosPorData(String filtro) {
        List<Agendamento> agendamentos;

        if ("today".equals(filtro)) {
            agendamentos = listarPorDia();

        } else if ("week".equals(filtro)) {
            agendamentos = listarPorSemanaAtual();

        } else if ("month".equals(filtro)) {

            agendamentos = listarAgendamentoMesAtual();

        } else if ("year".equals(filtro)) {
            agendamentos = listarPeloAnoAtual();

        } else {
            agendamentos = listarTodosAgendamentosAtivos();
        }
        return agendamentos;
    }
}
