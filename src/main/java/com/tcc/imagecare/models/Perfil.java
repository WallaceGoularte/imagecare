package com.tcc.imagecare.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Perfil {
    MEDICO(0, "Médico"),
    PACIENTE(1, "Paciente"),
    ADM(2, "Adm");

    private final int valor;
    private final String descricao;
}
