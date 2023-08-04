package com.tibesoft.listsfinaceoffline.data.database;

import android.content.Context;

import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.tibesoft.listsfinaceoffline.data.dao.ListDao;

public abstract class ListDatabase extends RoomDatabase {
    private static ListDatabase instance;

    public abstract ListDao listDao();

    public static synchronized ListDatabase getInstance(Context context){
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    ListDatabase.class, "list_database")
                    .fallbackToDestructiveMigration()
                    .build();
        }

        return instance;
    }
}
