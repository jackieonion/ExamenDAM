package com.example.dam2m8_exemplellistadetall.ui.Assistir;

import android.app.Application;

import androidx.lifecycle.ViewModel;

import com.example.dam2m8_exemplellistadetall.Model.Assistent;
import com.example.dam2m8_exemplellistadetall.Room.ExamenRepository;

public class AssistirViewModel extends ViewModel {

    private ExamenRepository repository;

    public AssistirViewModel() {
    }

    public AssistirViewModel(Application application) {
        repository = new ExamenRepository(application);
    }

    void aceptarAsistir(final String nom, final String cognom, final String email, final String telefon, final String edat, final String esdeveniment){
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                repository.insertAssistent(new Assistent(nom, cognom, email, telefon, edat, esdeveniment));
                System.out.println("inserted succefully");
            }
        });
        thread.start();
    }
}