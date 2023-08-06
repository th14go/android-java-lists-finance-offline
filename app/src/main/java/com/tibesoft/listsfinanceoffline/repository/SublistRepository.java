package com.tibesoft.listsfinanceoffline.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.tibesoft.listsfinanceoffline.data.dao.SublistDao;
import com.tibesoft.listsfinanceoffline.data.database.FinanceDatabase;
import com.tibesoft.listsfinanceoffline.data.model.SubItem;
import com.tibesoft.listsfinanceoffline.util.AppExecutors;

import java.util.List;

public class SublistRepository {
    private SublistDao sublistDao;
    private LiveData<List<SubItem>> subItemForList;

    public SublistRepository(Application application){
        FinanceDatabase database = FinanceDatabase.getInstance(application);
        sublistDao = database.sublistDao();
    }

    public LiveData<List<SubItem>> getSubItemForList(int listId){
        subItemForList = sublistDao.getSublistFromList(listId);
        return subItemForList;
    }

    public void insert(SubItem subItem){
        AppExecutors.getInstance().diskIO().execute(() -> {
            sublistDao.insert(subItem);
        });
    }
}
