package com.formulario.saep.dto;

import com.formulario.saep.entity.TipoMovimentacao;

public class MovimentacaoDto {

    private Long id;
    private TipoMovimentacao tipo;
    private Integer quantidade;
    private Long produtoId;
    private Long usuarioId;

    public MovimentacaoDto() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public TipoMovimentacao getTipo() { return tipo; }
    public void setTipo(TipoMovimentacao tipo) { this.tipo = tipo; }

    public Integer getQuantidade() { return quantidade; }
    public void setQuantidade(Integer quantidade) { this.quantidade = quantidade; }

    public Long getProdutoId() { return produtoId; }
    public void setProdutoId(Long produtoId) { this.produtoId = produtoId; }

    public Long getUsuarioId() { return usuarioId; }
    public void setUsuarioId(Long usuarioId) { this.usuarioId = usuarioId; }
}