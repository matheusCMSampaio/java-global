package br.com.medvirtua.java_global.model.entity;

import java.time.LocalDate;

public class RegistroCliente {
    private Long id;
    private String nome;
    private String senha;
    private int cep;
    private LocalDate dataNascimento;

    public RegistroCliente() {
    }

    public RegistroCliente(Long id, String nome, String senha, int cep, LocalDate dataNascimento) {
        this.id = id;
        this.nome = nome;
        this.senha = senha;
        this.cep = cep;
        this.dataNascimento = dataNascimento;
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

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getCep() {
        return cep;
    }

    public void setCep(int cep) {
        this.cep = cep;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}
