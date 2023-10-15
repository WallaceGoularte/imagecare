package com.tcc.imagecare.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum TipoExame {

    MAMOGRAFIA(0, "Mamografia"),
    ULTRASSOM(1, "Ultrassom"),
    TOMOGRAFIA(2, "Tomografia"),
    RESSONANCIA(3, "Ressonância");

    private final int valor;
    private final String descricao;

    public static TipoExame fromDescricao(String descricao) {
        for (TipoExame tipo : values()) {
            if (tipo.getDescricao().equalsIgnoreCase(descricao)) {
                return tipo;
            }
        }
        throw new IllegalArgumentException("Descrição inválida: " + descricao);
    }

}
