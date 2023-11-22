package br.com.medvirtua.java_global.model.entity;

public class Contato {
    private String tipoContato;
    private int numero;
    private String email;
    private Long id;

    public Contato() {
    }

    public Contato(String tipoContato, int numero, String email, Long id) {
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

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
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
