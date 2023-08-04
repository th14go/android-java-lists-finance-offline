package com.tibesoft.listsfinaceoffline.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.tibesoft.listsfinaceoffline.data.model.Item;
import com.tibesoft.listsfinaceoffline.repository.ListRepository;

import java.util.List;

public class ListViewModel extends AndroidViewModel {

    private LiveData<List<Item>> allItems;
    private ListRepository listRepository;

    public ListViewModel(@NonNull Application application) {
        super(application);
        listRepository = new ListRepository(application);
        allItems = listRepository.getAllItems();
    }

    public LiveData<List<Item>> getAllItems(){
        return allItems;
    }
}
