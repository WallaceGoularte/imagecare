package com.tcc.imagecare.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Getter
public enum HorasAgendamento {

    HORA_00("08:00"),
    HORA_01("09:00"),
    HORA_02("10:00"),
    HORA_03("11:00"),
    HORA_04("14:00"),
    HORA_05("15:00");

    private final String hora;

    public static List<String> fromHora() {
        List<String> hora = new ArrayList<>();

        for (HorasAgendamento e : values()) {
            hora.add(e.getHora());
        }
        return hora;
    }

    public static HorasAgendamento fromHora(String hora) {
        for (HorasAgendamento e : values()) {
            if (e.hora.equals(hora)) {
                return e;
            }
        }
        throw new IllegalArgumentException("Hora inválida: " + hora);
    }
}
