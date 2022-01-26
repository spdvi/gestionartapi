package spdvi.gestionartapi.models;

import java.time.LocalDateTime;

public class Comentari {
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDateTime getDataihora() {
        return dataihora;
    }

    public void setDataihora(LocalDateTime dataihora) {
        this.dataihora = dataihora;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getValoracio() {
        return valoracio;
    }

    public void setValoracio(int valoracio) {
        this.valoracio = valoracio;
    }
    private String text;
    private LocalDateTime dataihora;
    private String nom;
    private int valoracio;
}
