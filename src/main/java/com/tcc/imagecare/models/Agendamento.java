package com.tcc.imagecare.models;

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
    private LocalDateTime data;

    @Column(name = "status")
    private Status status;

    @ManyToOne
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;

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
