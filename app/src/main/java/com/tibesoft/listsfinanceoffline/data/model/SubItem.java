package com.tibesoft.listsfinanceoffline.data.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "sublist_table")
public class SubItem {
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "subitem_name")
    private String subItem_name;

    @ColumnInfo(name = "list_id")
    private int listId;

    public SubItem(String subItem_name, int listId) {
        this.subItem_name = subItem_name;
        this.listId = listId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSubItem_name() {
        return subItem_name;
    }

    public void setSubItem_name(String subItem_name) {
        this.subItem_name = subItem_name;
    }

    public int getListId() {
        return listId;
    }

    public void setListId(int listId) {
        this.listId = listId;
    }
}
