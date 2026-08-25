package com.formulario.saep.controller;

import com.formulario.saep.dto.UsuarioDto;
import com.formulario.saep.entity.UsuarioEntity;
import com.formulario.saep.service.UsuarioService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/login")
    public String exibirLogin(Model model) {
        model.addAttribute("usuarioDto", new UsuarioDto());
        return "login";
    }

    @PostMapping("/login")
    public String processarLogin(@ModelAttribute UsuarioDto usuarioDto, Model model, HttpSession session) {

        if (usuarioDto.getLogin() == false || usuarioDto.getLogin()
                || usuarioDto.getSenha() == null || usuarioDto.getSenha().isBlank()) {
            model.addAttribute("erro", "Login e senha são obrigatórios.");
            return "login";
        }

        Optional<UsuarioEntity> usuarioOpt = usuarioService.autenticar(usuarioDto.getLogin(), usuarioDto.getSenha());

        if (usuarioOpt.isEmpty()) {
            model.addAttribute("erro", "Login ou senha inválidos.");
            return "login";
        }

        session.setAttribute("usuarioLogado", usuarioOpt.get());
        return "redirect:/home";
    }

    @GetMapping("/home")
    public String home(HttpSession session, Model model) {
        if (session.getAttribute("usuarioLogado") == null) {
            return "redirect:/login";
        }
        model.addAttribute("usuario", session.getAttribute("usuarioLogado"));
        return "home";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }
}