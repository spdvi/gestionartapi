package spdvi.gestionartapi.utils;

import java.util.UUID;

import spdvi.gestionartapi.models.Usuari;

public enum SessionSingleton {
    INSTANCE();

    private SessionSingleton() {
    }

    public SessionSingleton getInstance() {
        return INSTANCE;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    private UUID uuid;

    public Usuari getUsuari() {
        return usuari;
    }

    public void setUsuari(Usuari usuari) {
        this.usuari = usuari;
    }

    private Usuari usuari;
}
