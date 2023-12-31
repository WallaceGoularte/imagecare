package com.tcc.imagecare.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "funcionario")
@Data
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nome")
    private String nome;

    @OneToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuarioId;

    @OneToOne
    @JoinColumn(name = "medico_id")
    private Medico medicoId;

}
