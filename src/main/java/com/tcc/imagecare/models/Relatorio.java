package com.tcc.imagecare.models;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "relatorio")
@Data
public class Relatorio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "detalhes_relatorio")
    private String detalhesRelatorio;

    @Column(name = "data")
    private LocalDateTime data;

    @OneToMany
    @JoinColumn(name = "exame_id")
    private List<Exame> exameId;

}