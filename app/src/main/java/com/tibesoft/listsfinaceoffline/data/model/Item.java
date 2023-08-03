package com.tibesoft.listsfinaceoffline.data.model;

public class Item {
    private int id;
    private String itemName;

    public Item(int id, String itemName) {
        this.id = id;
        this.itemName = itemName;
    }

    public int getId() {
        return id;
    }

    public String getItemName() {
        return itemName;
    }
}
