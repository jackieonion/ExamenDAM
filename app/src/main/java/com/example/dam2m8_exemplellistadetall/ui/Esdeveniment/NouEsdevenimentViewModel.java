package com.example.dam2m8_exemplellistadetall.ui.Esdeveniment;

import android.app.Application;

import androidx.lifecycle.ViewModel;

import com.example.dam2m8_exemplellistadetall.Model.Assistent;
import com.example.dam2m8_exemplellistadetall.Model.Esdeveniment;
import com.example.dam2m8_exemplellistadetall.PSQL.PostgressConnection;
import com.example.dam2m8_exemplellistadetall.Room.ExamenRepository;

public class NouEsdevenimentViewModel extends ViewModel {

    public NouEsdevenimentViewModel() {
    }

    void aceptarAsistir(Esdeveniment esdeveniment){
        PostgressConnection postgressConnection = new PostgressConnection(esdeveniment);
        postgressConnection.sqlThread.start();
    }
}