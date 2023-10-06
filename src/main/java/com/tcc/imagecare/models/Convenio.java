package com.tcc.imagecare.models;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "convenio")
@Data
public class Convenio implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "numero_cartao")
    private int numeroCartao;

    @Column(name = "plano")
    private String plano;

    @OneToOne
    @JoinColumn(name = "paciente_id")
    private Paciente pacienteId;

}
