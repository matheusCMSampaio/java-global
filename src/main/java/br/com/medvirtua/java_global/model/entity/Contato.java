package br.com.medvirtua.java_global.model.entity;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class Contato {
    @NotBlank
    private String tipoContato;
    @NotNull
    private Long numero;
    @NotBlank
    private String email;
    @NotNull
    private Long id;

    public Contato() {
    }

    public Contato(@NotBlank String tipoContato, @NotNull Long numero, @NotBlank String email,@NotNull Long id) {
        this.tipoContato = tipoContato;
        this.numero = numero;
        this.email = email;
        this.id = id;
    }

    public String getTipoContato() {
        return tipoContato;
    }

    public void setTipoContato(String tipoContato) {
        this.tipoContato = tipoContato;
    }

    public Long getNumero() {
        return numero;
    }

    public void setNumero(Long numero) {
        this.numero = numero;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
