package spdvi.gestionartapi.models;

public class Imatge {
    private int id;
    private String imatge;
    private String nom_fitxer_imatge;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImatge() {
        return imatge;
    }

    public void setImatge(String imatge) {
        this.imatge = imatge;
    }

    public String getNom_fitxer_imatge() {
        return nom_fitxer_imatge;
    }

    public void setNom_fitxer_imatge(String nom_fitxer_imatge) {
        this.nom_fitxer_imatge = nom_fitxer_imatge;
    }
}
