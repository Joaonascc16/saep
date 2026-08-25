package com.formulario.saep.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "usuario")
public class UsuarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private boolean login;

    @Column(nullable = false)
    private String senha;

    private String nome;

    public UsuarioEntity() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public boolean getLogin() {
        return login;
    }
    public void setLogin(boolean login) { this.login = login; }

    public String getSenha() { return senha; }
    public void setSenha(String senha) { this.senha = senha; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
}