package br.com.medvirtua.java_global.model.entity;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class Calendario {
    @FutureOrPresent
    private LocalDate dataMarcada;
    @NotBlank
    private String nomeEvento;
    @NotBlank
    private String tipoEvento;
    @NotNull
    private Long idCalendario;
    @NotNull
    private Long idUsuario;

    public Calendario() {
    }

    public Calendario(@FutureOrPresent LocalDate dataMarcada,@NotBlank String nomeEvento,@NotBlank String tipoEvento,
                     @NotNull Long idCalendario, @NotNull Long idUsuario) {
        this.dataMarcada = dataMarcada;
        this.nomeEvento = nomeEvento;
        this.tipoEvento = tipoEvento;
        this.idCalendario = idCalendario;
        this.idUsuario = idUsuario;
    }

    public LocalDate getDataMarcada() {
        return dataMarcada;
    }

    public void setDataMarcada(LocalDate dataMarcada) {
        this.dataMarcada = dataMarcada;
    }

    public String getNomeEvento() {
        return nomeEvento;
    }

    public void setNomeEvento(String nomeEvento) {
        this.nomeEvento = nomeEvento;
    }

    public String getTipoEvento() {
        return tipoEvento;
    }

    public void setTipoEvento(String tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    public Long getIdCalendario() {
        return idCalendario;
    }

    public void setIdCalendario(Long idCalendario) {
        this.idCalendario = idCalendario;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }
}
