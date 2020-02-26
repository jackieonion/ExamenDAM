package com.example.dam2m8_exemplellistadetall.ui.Assistents;

import com.example.dam2m8_exemplellistadetall.Model.Assistent;
import com.example.dam2m8_exemplellistadetall.Model.Esdeveniment;

import java.util.ArrayList;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class AssistentsViewModel extends ViewModel {

    private MutableLiveData<ArrayList<Assistent>> mLlistat;
    private MutableLiveData<Assistent> mUsuari;

    public AssistentsViewModel() {
        mLlistat = new MutableLiveData<>();
        mUsuari = new MutableLiveData<>();
        aconseguirLlistat();
    }

    private void aconseguirLlistat() {

        //Aqui aconseguim el llistat picant la info, pero normalment vindrà de BBDD
        ArrayList<Assistent> llistat_temporal = new ArrayList<>();

        llistat_temporal.add(new Assistent("Andrey", "Melnikov", "andrey@jda.com", "666666666", "19", "esdeveniment"));
//        llistat_temporal.add(new Esdeveniment());
//        llistat_temporal.add(new Esdeveniment());


        mLlistat.setValue(llistat_temporal);

    }

    public LiveData<ArrayList<Assistent>> getLlistat() {
        return mLlistat;
    }

    public LiveData<Assistent> getAssistent() {
        return mUsuari;
    }

    public void getDetallUsuari(int posicio){

        //Se suposa que jo tinc accés aquí a la llista usuari
        //fent crida a BBDD, inclus a un usuari concret fent SELECT WHERE
        mUsuari.setValue(mLlistat.getValue().get(posicio));
    }
}