package com.tcc.imagecare.repositories;

import com.tcc.imagecare.models.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface AgendamentoRepository extends JpaRepository<Agendamento, Integer> {

    List<Agendamento> findByData(LocalDateTime data);

    List<Agendamento> findByDataBetween(LocalDateTime dataInicial, LocalDateTime dataFinal);
}
