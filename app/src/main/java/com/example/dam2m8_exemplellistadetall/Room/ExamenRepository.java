package com.example.dam2m8_exemplellistadetall.Room;

import android.app.Application;

import com.example.dam2m8_exemplellistadetall.Model.Assistent;
import com.example.dam2m8_exemplellistadetall.Model.Esdeveniment;

import java.util.List;

public class ExamenRepository {

    private AssistentDao assistentDao;
    private List<Assistent> assistentList;

    public ExamenRepository(Application application) {
        ExamenRoomDb fichappRoomDb = ExamenRoomDb.getDatabase(application.getApplicationContext());
        assistentDao = fichappRoomDb.assistentDao();
    }

    public List<Assistent> getAssistents() {
        return assistentList;
    }

    public Assistent getAssistentsByEsdeveniment(String esdeveniment) {
        return assistentDao.getAssistentsByEsdeveniment(esdeveniment);
    }

    public void insertAssistent(final Assistent assistent) {
        ExamenRoomDb.databaseWriterExecutor.execute(new Runnable() {
            @Override
            public void run() {
                assistentDao.insertAssistent(assistent);
            }
        });
    }
}
