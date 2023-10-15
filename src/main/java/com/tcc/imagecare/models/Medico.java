package com.tcc.imagecare.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "medico")
@Data
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "crm")
    private String crm;

}
