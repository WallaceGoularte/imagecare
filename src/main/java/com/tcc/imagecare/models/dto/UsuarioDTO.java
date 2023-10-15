package com.tcc.imagecare.models.dto;

import lombok.Data;

@Data
public class UsuarioDTO {
    private String login;
    private String senha;

    public UsuarioDTO() {
    }

    public UsuarioDTO(String login, String senha) {
        this.login = login;
        this.senha = senha;
    }

}
