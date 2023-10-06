package com.tcc.imagecare.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;

@AllArgsConstructor
@Getter
public enum Status {
    AGENDADO(0, "Agendado"),
    CONCLUIDO(1, "Concluído"),
    CANCELADO(2, "Cancelado");

    private final int valor;
    private final String descricao;
}
