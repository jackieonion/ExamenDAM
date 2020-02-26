package com.example.dam2m8_exemplellistadetall.Model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "assistant_table")
public class Assistent {
    @PrimaryKey(autoGenerate = true)
    private int id;

    String nom, cognom, email, telefon, edat, esdeveniment;

    public Assistent(String nom, String cognom, String email, String telefon, String edat, String esdeveniment) {
        this.nom = nom;
        this.cognom = cognom;
        this.email = email;
        this.telefon = telefon;
        this.edat = edat;
        this.esdeveniment = esdeveniment;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public String getEsdeveniment() {
        return esdeveniment;
    }

    public void setEsdeveniment(String esdeveniment) {
        this.esdeveniment = esdeveniment;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCognom() {
        return cognom;
    }

    public void setCognom(String cognom) {
        this.cognom = cognom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getEdat() {
        return edat;
    }

    public void setEdat(String edat) {
        this.edat = edat;
    }
}
