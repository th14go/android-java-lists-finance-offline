package com.tibesoft.listsfinanceoffline.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.tibesoft.listsfinanceoffline.data.model.Item;
import com.tibesoft.listsfinanceoffline.repository.ListRepository;

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

    public void insert(Item item) {
        listRepository.insert(item);
    }
}
