package br.com.medvirtua.java_global.model.entity;

import java.time.LocalDate;

public class Cliente {
    private Long id;
    private String nome;
    private LocalDate dataNascimento;
    private String senha;
    private String cep;
    private String contato;

    public Cliente() {
    }

    public Cliente(String nome, LocalDate dataNascimento, String senha, String cep, String contato) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.senha = senha;
        this.cep = cep;
        this.contato = contato;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }
}
