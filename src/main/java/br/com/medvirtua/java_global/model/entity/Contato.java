package br.com.medvirtua.java_global.model.entity;

public class Contato {
    private String tipoContato;
    private int numeroTelefone;
    private String email;

    public Contato() {
    }

    public Contato(String tipoContato, int numeroTelefone, String email) {
        this.tipoContato = tipoContato;
        this.numeroTelefone = numeroTelefone;
        this.email = email;
    }

    public String getTipoContato() {
        return tipoContato;
    }

    public void setTipoContato(String tipoContato) {
        this.tipoContato = tipoContato;
    }

    public int getNumeroTelefone() {
        return numeroTelefone;
    }

    public void setNumeroTelefone(int numeroTelefone) {
        this.numeroTelefone = numeroTelefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
