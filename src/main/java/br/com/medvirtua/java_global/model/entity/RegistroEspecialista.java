package br.com.medvirtua.java_global.model.entity;

public class RegistroEspecialista {
    private Long id;
    private String nome;
    private String senha;
    private int crm;

    public RegistroEspecialista(Long id, String nome, String senha, int crm) {
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
