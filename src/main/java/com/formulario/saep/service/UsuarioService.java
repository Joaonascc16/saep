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
        Optional<UsuarioEntity> usuario = usuarioRepository.findByLoginAndSenha(login, senha);

        if (usuario.isPresent() && usuario.get().getSenha().equals(senha)) {
            System.out.println(usuario);
            return usuario;
        }
        return Optional.empty();
    }
}