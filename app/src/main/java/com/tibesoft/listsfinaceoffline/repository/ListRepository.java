package com.tibesoft.listsfinaceoffline.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.tibesoft.listsfinaceoffline.data.dao.ListDao;
import com.tibesoft.listsfinaceoffline.data.database.ListDatabase;
import com.tibesoft.listsfinaceoffline.data.model.Item;

import java.util.List;

public class ListRepository {
    private ListDao listDao;
    private LiveData<List<Item>> allItems;

    public ListRepository(Application application){
        ListDatabase database = ListDatabase.getInstance(application);
        listDao = database.listDao();
        allItems = listDao.getAllItems();
    }

    public LiveData<List<Item>> getAllItems(){
        return allItems;
    }
}
