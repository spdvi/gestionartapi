package spdvi.gestionartapi.models;

public class Espai {
    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    String nom;

    public String getRegistre() {
        return this.registre;
    }

    public void setRegistre(String registre) {
        this.registre = registre;
    }

    String registre;

    public String getDescripcio() {
        return this.descripcio;
    }

    public void setDescripcio(String descripcio) {
        this.descripcio = descripcio;
    }

    String descripcio;

    public String getMunicipi() {
        return this.municipi;
    }

    public void setMunicipi(String municipi) {
        this.municipi = municipi;
    }

    String municipi;

    public String getAdreca() {
        return this.adreca;
    }

    public void setAdreca(String adreca) {
        this.adreca = adreca;
    }

    String adreca;

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    String email;

    public String getWeb() {
        return this.web;
    }

    public void setWeb(String web) {
        this.web = web;
    }

    String web;

    public String getTelefon() {
        return this.telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    String telefon;

    public String getTipus() {
        return this.tipus;
    }

    public void setTipus(String tipus) {
        this.tipus = tipus;
    }

    String tipus;

    @Override
    public String toString() {
        return registre + " " + tipus + " " + nom + " " + municipi;
    }
}
