package com.tibesoft.listsfinaceoffline.data.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.tibesoft.listsfinaceoffline.data.dao.ListDao;
import com.tibesoft.listsfinaceoffline.data.model.Item;

@Database(entities = {Item.class}, version = 1, exportSchema = false)
public abstract class FinanceDatabase extends RoomDatabase {
    private static FinanceDatabase instance;

    public abstract ListDao listDao();

    public static synchronized FinanceDatabase getInstance(Context context){
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    FinanceDatabase.class, "list_database")
                    .fallbackToDestructiveMigration()
                    .build();
        }

        return instance;
    }
}
