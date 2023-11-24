package br.com.medvirtua.java_global.model.entity;

import jakarta.validation.constraints.NotNull;

public class Medidas {
    private String nomeVacina;
    @NotNull
    private Long idVacina;
    private String descricaoMedida;
    private String descricaoRemedio;
    private String nomeRemedio;
    private Long idDoenca;

    public Medidas() {
    }

    public String getNomeVacina() {
        return nomeVacina;
    }

    public void setNomeVacina(String nomeVacina) {
        this.nomeVacina = nomeVacina;
    }

    public Long getIdVacina() {
        return idVacina;
    }

    public void setIdVacina(Long idVacina) {
        this.idVacina = idVacina;
    }

    public String getDescricaoMedida() {
        return descricaoMedida;
    }

    public void setDescricaoMedida(String descricaoMedida) {
        this.descricaoMedida = descricaoMedida;
    }

    public String getDescricaoRemedio() {
        return descricaoRemedio;
    }

    public void setDescricaoRemedio(String descricaoRemedio) {
        this.descricaoRemedio = descricaoRemedio;
    }

    public String getNomeRemedio() {
        return nomeRemedio;
    }

    public void setNomeRemedio(String nomeRemedio) {
        this.nomeRemedio = nomeRemedio;
    }

    public Long getIdDoenca() {
        return idDoenca;
    }

    public void setIdDoenca(Long idDoenca) {
        this.idDoenca = idDoenca;
    }
}
