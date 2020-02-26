package com.example.dam2m8_exemplellistadetall.Room;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.dam2m8_exemplellistadetall.Model.Assistent;
import com.example.dam2m8_exemplellistadetall.Model.Esdeveniment;

import java.util.List;

@Dao
public interface AssistentDao {
    @Insert
    void insertAssistent(Assistent assistent);

    @Query("SELECT * FROM assistant_table")
    List<Assistent> getAssistents();

    @Query("SELECT * FROM assistant_table where esdeveniment = :esdeveniment")
    Assistent getAssistentsByEsdeveniment(String esdeveniment);
}
