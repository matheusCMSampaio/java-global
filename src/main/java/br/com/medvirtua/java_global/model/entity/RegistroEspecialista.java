package br.com.medvirtua.java_global.model.entity;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class RegistroEspecialista {
    private Long id;
    @NotBlank
    private String nome;
    @NotBlank
    private String senha;
    @NotNull
    private int crm;

    public RegistroEspecialista(Long id, @NotBlank String nome, @NotBlank String senha, @NotNull int crm) {
        this.id = id;
        this.nome = nome;
        this.senha = senha;
        this.crm = crm;
    }

    public RegistroEspecialista() {
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

    public int getCrm() {
        return crm;
    }

    public void setCrm(int crm) {
        this.crm = crm;
    }
}
