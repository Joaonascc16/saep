package com.formulario.saep.service;

import com.formulario.saep.entity.MovimentacaoEntity;
import com.formulario.saep.entity.ProdutoEntity;
import com.formulario.saep.entity.TipoMovimentacao;
import com.formulario.saep.repository.MovimentacaoRepository;
import com.formulario.saep.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovimentacaoService {

    @Autowired
    private MovimentacaoRepository movimentacaoRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    public List<MovimentacaoEntity> listarTodas() {
        return movimentacaoRepository.findAll();
    }

    public MovimentacaoEntity registrar(MovimentacaoEntity movimentacao) {
        ProdutoEntity produto = movimentacao.getProduto();

        if (movimentacao.getTipo() == TipoMovimentacao.ENTRADA) {
            produto.setQuantidade(produto.getQuantidade() + movimentacao.getQuantidade());
        } else {
            if (produto.getQuantidade() < movimentacao.getQuantidade()) {
                throw new IllegalArgumentException("Estoque insuficiente para essa saída.");
            }
            produto.setQuantidade(produto.getQuantidade() - movimentacao.getQuantidade());
        }

        produtoRepository.save(produto);
        return movimentacaoRepository.save(movimentacao);
    }
}