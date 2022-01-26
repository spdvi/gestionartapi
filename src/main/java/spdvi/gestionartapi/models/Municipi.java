package spdvi.gestionartapi.models;

public class Municipi {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getIlla() {
        return illa;
    }

    public void setIlla(String illa) {
        this.illa = illa;
    }

    private int id;
    private String nom;
    private String illa;

    @Override
    public String toString() {
        return nom;
    }
}
