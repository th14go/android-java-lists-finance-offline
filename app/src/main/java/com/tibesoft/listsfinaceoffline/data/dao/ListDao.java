package com.tibesoft.listsfinaceoffline.data.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.tibesoft.listsfinaceoffline.data.model.Item;

import java.util.List;

@Dao
public interface ListDao {

    @Insert
    void insert(Item item);

    @Query("SELECT * FROM item_table")
    LiveData<List<Item>> getAllItems();
}
