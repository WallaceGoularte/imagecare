package com.tcc.imagecare.services;

import com.tcc.imagecare.models.Usuario;
import com.tcc.imagecare.models.dto.UsuarioDTO;
import com.tcc.imagecare.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository userRepository;

    public boolean autenticar(UsuarioDTO usuarioDTO) {
        Usuario user = buscarUsuarioPorLogin(usuarioDTO);

        if (user == null) {
            return false;
        }

        return (usuarioDTO.getLogin().equals(user.getLogin()))
                && (usuarioDTO.getSenha().equals(user.getSenha()));
    }

    private Usuario buscarUsuarioPorLogin(UsuarioDTO usuarioDTO) {
        return userRepository.findByLogin(usuarioDTO.getLogin());
    }
}
