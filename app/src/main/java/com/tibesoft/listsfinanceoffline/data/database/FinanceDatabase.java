package com.tibesoft.listsfinanceoffline.data.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.tibesoft.listsfinanceoffline.data.dao.ListDao;
import com.tibesoft.listsfinanceoffline.data.dao.SublistDao;
import com.tibesoft.listsfinanceoffline.data.model.Item;
import com.tibesoft.listsfinanceoffline.data.model.SubItem;

@Database(entities = {Item.class, SubItem.class}, version = 1, exportSchema = false)
public abstract class FinanceDatabase extends RoomDatabase {
    private static FinanceDatabase instance;

    public abstract ListDao listDao();
    public abstract SublistDao sublistDao();

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
