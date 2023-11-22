package br.com.medvirtua.java_global.model.entity;

import java.time.LocalDate;

public class Calendario {
    private LocalDate dataMarcada;
    private String nomeEvento;
    private String tipoEvento;
    private Long idCalendario;
    private Long idUsuario;

    public Calendario() {
    }

    public Calendario(LocalDate dataMarcada, String nomeEvento, String tipoEvento, Long idCalendario, Long idUsuario) {
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
