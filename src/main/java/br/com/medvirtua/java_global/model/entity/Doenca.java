package br.com.medvirtua.java_global.model.entity;

public class Doenca {
    private String nome;
    private String tipo;
    private String faixaEtaria;
    private String descricao;
    private Long idUsuario;
    private Long idDoenca;

    public Doenca() {
    }

    public Doenca(String nome, String tipo, String faixaEtaria, String descricao, Long idUsuario, Long idDoenca) {
        this.nome = nome;
        this.tipo = tipo;
        this.faixaEtaria = faixaEtaria;
        this.descricao = descricao;
        this.idUsuario = idUsuario;
        this.idDoenca = idDoenca;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getFaixaEtaria() {
        return faixaEtaria;
    }

    public void setFaixaEtaria(String faixaEtaria) {
        this.faixaEtaria = faixaEtaria;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Long getIdDoenca() {
        return idDoenca;
    }

    public void setIdDoenca(Long idDoenca) {
        this.idDoenca = idDoenca;
    }
}
