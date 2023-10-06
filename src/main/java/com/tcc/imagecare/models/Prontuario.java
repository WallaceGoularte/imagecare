package com.tcc.imagecare.models;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "prontuario")
@Data
public class Prontuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "informacoes")
    private String informacoes;

    @OneToOne
    @JoinColumn(name = "paciente_id")
    private Paciente pacienteId;
}
