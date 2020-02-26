package com.example.dam2m8_exemplellistadetall.Room;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.dam2m8_exemplellistadetall.Model.Assistent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Assistent.class}, version = 1, exportSchema = false)
public abstract class ExamenRoomDb extends RoomDatabase {

    public abstract AssistentDao assistentDao();

    private static volatile ExamenRoomDb INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriterExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    static ExamenRoomDb getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (ExamenRoomDb.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            ExamenRoomDb.class, "examen_db")
                            .addCallback(roomDatabaseCallback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    private static RoomDatabase.Callback roomDatabaseCallback = new RoomDatabase.Callback() {
        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);
        }
    };
}

