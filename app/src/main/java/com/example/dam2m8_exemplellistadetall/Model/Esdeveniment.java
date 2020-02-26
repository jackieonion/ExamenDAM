package com.example.dam2m8_exemplellistadetall.Model;

import androidx.room.Entity;

import java.io.Serializable;

public class Esdeveniment implements Serializable {

    String title, data, lloc, organitzador, sala, preu, aforament, descripcio;


    public Esdeveniment() {
    }

    public Esdeveniment(String data, String lloc, String organitzador, String sala, String preu, String aforament, String descripcio, String title) {
        this.title = title;
        this.data = data;
        this.lloc = lloc;
        this.organitzador = organitzador;
        this.sala = sala;
        this.preu = preu;
        this.aforament = aforament;
        this.descripcio = descripcio;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getLloc() {
        return lloc;
    }

    public void setLloc(String lloc) {
        this.lloc = lloc;
    }

    public String getOrganitzador() {
        return organitzador;
    }

    public void setOrganitzador(String organitzador) {
        this.organitzador = organitzador;
    }

    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }

    public String getPreu() {
        return preu;
    }

    public void setPreu(String preu) {
        this.preu = preu;
    }

    public String getAforament() {
        return aforament;
    }

    public void setAforament(String aforament) {
        this.aforament = aforament;
    }

    public String getDescripcio() {
        return descripcio;
    }

    public void setDescripcio(String descripcio) {
        this.descripcio = descripcio;
    }
}
