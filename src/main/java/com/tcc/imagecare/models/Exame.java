package com.tcc.imagecare.models;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "exame")
@Data
public class Exame implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nome")
    private TipoExame nome;

    @Column(name = "data")
    private LocalDateTime data;

    @Column(name = "duracao")
    private int duracao;

    @Column(name = "observacao_resultado")
    private String observacaoResultado;

    void adicionarExame(Exame exame){

    }

    void atualizarExame(Exame exame){

    }

}
