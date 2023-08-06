package com.tibesoft.listsfinanceoffline.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.tibesoft.listsfinanceoffline.data.model.SubItem;
import com.tibesoft.listsfinanceoffline.repository.SublistRepository;

import java.util.List;

public class SublistViewModel extends AndroidViewModel {
    private SublistRepository sublistRepository;
    private LiveData<List<SubItem>> sublistList;

    public SublistViewModel(@NonNull Application application) {
        super(application);
        sublistRepository = new SublistRepository(application);
    }

    public LiveData<List<SubItem>> getSublistForList(int listId){
        sublistList = sublistRepository.getSubItemForList(listId);
        return sublistList;
    }
}
