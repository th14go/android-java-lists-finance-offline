package com.tibesoft.listsfinaceoffline.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.tibesoft.listsfinaceoffline.data.model.Item;

import java.util.List;

public class ListViewModel extends AndroidViewModel {

    private LiveData<List<Item>> allItems;

    public ListViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<List<Item>> getAllItems(){
        return allItems;
    }
}
