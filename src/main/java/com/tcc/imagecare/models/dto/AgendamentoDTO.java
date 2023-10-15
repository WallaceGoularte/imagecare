package com.tcc.imagecare.models.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;


@Data
public class AgendamentoDTO {
    private String exame;
    private String medico;
    private LocalDateTime data;

}
