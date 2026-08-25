package com.formulario.saep.dto;

public class UsuarioDto {

    private boolean login;
    private String senha;

    public UsuarioDto() {}

    public boolean getLogin() { return login; }
    public void setLogin(boolean login) { this.login = login; }

    public String getSenha() { return senha; }
    public void setSenha(String senha) { this.senha = senha; }
}