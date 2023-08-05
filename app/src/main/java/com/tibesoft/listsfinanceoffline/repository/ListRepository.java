package com.tibesoft.listsfinanceoffline.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.tibesoft.listsfinanceoffline.data.dao.ListDao;
import com.tibesoft.listsfinanceoffline.data.database.FinanceDatabase;
import com.tibesoft.listsfinanceoffline.data.model.Item;
import com.tibesoft.listsfinanceoffline.util.AppExecutors;

import java.util.List;

public class ListRepository {
    private ListDao listDao;
    private LiveData<List<Item>> allItems;

    public ListRepository(Application application){
        FinanceDatabase database = FinanceDatabase.getInstance(application);
        listDao = database.listDao();
        allItems = listDao.getAllItems();
    }

    public LiveData<List<Item>> getAllItems(){
        return allItems;
    }

    public void insert(Item item){
        AppExecutors.getInstance().diskIO().execute(() -> {
            listDao.insert(item);
        });
    }
}
