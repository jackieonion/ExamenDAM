package com.example.dam2m8_exemplellistadetall.ui.llista;

import com.example.dam2m8_exemplellistadetall.Model.Esdeveniment;

import java.util.ArrayList;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class LlistaViewModel extends ViewModel {

    private MutableLiveData<ArrayList<Esdeveniment>> mLlistat;
    private MutableLiveData<Esdeveniment> mUsuari;

    public LlistaViewModel() {
        mLlistat = new MutableLiveData<>();
        mUsuari = new MutableLiveData<>();
        aconseguirLlistat();
    }

    private void aconseguirLlistat() {

        //Aqui aconseguim el llistat picant la info, pero normalment vindrà de BBDD
        ArrayList<Esdeveniment> llistat_temporal = new ArrayList<>();

        llistat_temporal.add(new Esdeveniment("04/03/2020", "Joan d'Austria", "organitzador", "sala", "preu", "aforament", "descripcio", "Jornada Ciberseguretat"));
//        llistat_temporal.add(new Esdeveniment());
//        llistat_temporal.add(new Esdeveniment());


        mLlistat.setValue(llistat_temporal);

    }

    public LiveData<ArrayList<Esdeveniment>> getLlistat() {
        return mLlistat;
    }

    public LiveData<Esdeveniment> getUsuari() {
        return mUsuari;
    }

    public void getDetallUsuari(int posicio){

        //Se suposa que jo tinc accés aquí a la llista usuari
        //fent crida a BBDD, inclus a un usuari concret fent SELECT WHERE
        mUsuari.setValue(mLlistat.getValue().get(posicio));
    }
}