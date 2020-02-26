package com.example.dam2m8_exemplellistadetall.ui.detall;

import com.example.dam2m8_exemplellistadetall.Model.Esdeveniment;
import com.example.dam2m8_exemplellistadetall.ui.llista.LlistaViewModel;

import java.util.ArrayList;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class DetallViewModel extends ViewModel {

    private MutableLiveData<Esdeveniment> mEsdeveniment;
    private ArrayList<Esdeveniment> llistat_temporal;
    private LlistaViewModel llistaViewModel;

    public DetallViewModel() {
        mEsdeveniment = new MutableLiveData<>();
        llistat_temporal = new ArrayList<>();

        llistat_temporal.add(new Esdeveniment("data", "lloc", "organitzador", "sala", "preu", "aforament", "descripcio", "title"));
//        llistat_temporal.add(new Esdeveniment("nacho@jda.org","Ignacio","Torres","Informatica"));
//        llistat_temporal.add(new Esdeveniment("milena@jda.org","Juan C.","Milena","Informatica"));

    }

    public LiveData<Esdeveniment> getUsuari() {
        return mEsdeveniment;
    }

    public void getDetallUsuari(int posicio){

        //Se suposa que jo tinc accés aquí a la llista usuari
        //fent crida a BBDD, inclus a un usuari concret fent SELECT WHERE
        mEsdeveniment.setValue(llistat_temporal.get(posicio));
    }
}