package com.tcc.imagecare.models;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "pagamento")
@Data
public class Pagamento implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "valor")
    private Double valor;

    @Column(name = "data_pagamento")
    private LocalDate dataPagamento;

    @OneToOne
    @JoinColumn(name = "agenamento_id")
    private Agendamento agendamentoId;


    public void processarPagamento() {
        // Implementação para processar o pagamento
    }
}
