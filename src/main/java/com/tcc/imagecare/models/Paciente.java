package com.tcc.imagecare.models;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "paciente")
@Data
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;

    @Column(name = "sexo")
    private char sexo;

    @Column(name = "cpf")
    private String cpf;

    @Column(name = "data_cadastro")
    private LocalDate dataCadastro;

    @OneToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuarioId;


}

