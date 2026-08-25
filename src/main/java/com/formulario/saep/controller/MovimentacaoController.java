package com.formulario.saep.controller;

import com.formulario.saep.entity.MovimentacaoEntity;
import com.formulario.saep.service.MovimentacaoService;
import com.formulario.saep.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/movimentacoes")
public class MovimentacaoController {

    @Autowired
    private MovimentacaoService movimentacaoService;

    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("movimentacoes", movimentacaoService.listarTodas());
        return "movimentacoes/lista";
    }

    @GetMapping("/nova")
    public String novaForm(Model model) {
        model.addAttribute("movimentacao", new MovimentacaoEntity());
        model.addAttribute("produtos", produtoService.listarTodos());
        return "movimentacoes/form";
    }

    @PostMapping("/salvar")
    public String salvar(@ModelAttribute MovimentacaoEntity movimentacao, Model model) {
        try {
            movimentacaoService.registrar(movimentacao);
        } catch (IllegalArgumentException e) {
            model.addAttribute("erro", e.getMessage());
            model.addAttribute("produtos", produtoService.listarTodos());
            return "movimentacoes/form";
        }
        return "redirect:/movimentacoes";
    }
}