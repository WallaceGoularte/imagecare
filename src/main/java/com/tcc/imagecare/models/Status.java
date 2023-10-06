package com.tcc.imagecare.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;

@AllArgsConstructor
@Getter
public enum Status {
    AGENDADO(1, "Agendado"),
    CONCLUIDO(2, "Concluído"),
    CANCELADO(3, "Cancelado");

    private final int valor;
    private final String descricao;
}
