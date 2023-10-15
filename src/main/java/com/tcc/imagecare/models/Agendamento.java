package com.tcc.imagecare.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "agendamento")
@Data
public class Agendamento implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @Column(name = "data")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "America/Sao_Paulo")
    private LocalDateTime data;

    @Column(name = "status")
    private Status status;

    @ManyToOne
    @JoinColumn(name = "paciente_id")
    private Paciente pacienteId;

    @OneToOne
    @JoinColumn(name = "exame_id")
    private Exame exameId;

    @ManyToOne
    @JoinColumn(name = "funcionario_id")
    private Funcionario funcionarioId;

    void cancelar(Integer idAgendamento) {

    }

    Relatorio gerarRelatorio(Integer idAgendamento) {

        return null;
    }

}
