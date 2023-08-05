package com.tibesoft.listsfinanceoffline.data.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.tibesoft.listsfinanceoffline.data.model.SubItem;

import java.util.List;

@Dao
public interface SublistDao {
    @Insert
    void insert(SubItem subItem);

    @Query("SELECT * FROM sublist_table WHERE list_id = :listId")
    LiveData<List<SubItem>> getSublistFromList(int listId);
}
