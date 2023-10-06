package com.tcc.imagecare.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Perfil {
    MEDICO(1, "Médico"),
    PACIENTE(2, "Paciente"),
    ADM(3, "Adm");

    private final int valor;
    private final String descricao;
}
