package com.formulario.saep.service;

import com.formulario.saep.entity.UsuarioEntity;
import com.formulario.saep.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Optional<UsuarioEntity> autenticar(String login, String senha) {
        Optional<UsuarioEntity> usuario = usuarioRepository.findByLogin(login);

        if (usuario.isPresent() && usuario.get().getSenha().equals(senha)) {
            return usuario;
        }

        return Optional.empty();
    }
}