package spdvi.gestionartapi.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import spdvi.gestionartapi.Constants;

public class Usuari {

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private int id;

    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    String nom;

    public String getLlinatges() {
        return this.llinatges;
    }

    public void setLlinatges(String llinatges) {
        this.llinatges = llinatges;
    }

    String llinatges;

    public String getDni() {
        return this.dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    String dni;

    public String getTelefon() {
        return this.telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    String telefon;

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    String email;

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
//    @JsonIgnore
    private String password;

//    public byte[] getPasswordHash() {
//        return passwordHash;
//    }
//
//    public void setPasswordHash(byte[] passwordHash) {
//        this.passwordHash = passwordHash;
//    }
//
//    private byte[] passwordHash = new byte[256];
//
//    private byte[] profilePicture = new byte[Constants.MAX_IMAGE_FILE_SIZE];
//
//    public byte[] getProfilePicture() {
//        return profilePicture;
//    }
//
//    public void setProfilePicture(byte[] profilePicture) {
//        this.profilePicture = profilePicture;
//    }

    private boolean admin = false;

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }
}
