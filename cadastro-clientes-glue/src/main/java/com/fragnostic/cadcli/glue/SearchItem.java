package com.fragnostic.cadcli.glue;

import java.io.Serializable;

public class SearchItem<T> implements Serializable {

    private T itemId;
    private String itemValue;

    public SearchItem() {
    }

    public SearchItem(T itemId, String itemValue) {
        this.itemId = itemId;
        this.itemValue = itemValue;
    }

    public T getItemId() {
        return itemId;
    }

    public void setItemId(T itemId) {
        this.itemId = itemId;
    }

    public String getItemValue() {
        return itemValue;
    }

    public void setItemValue(String itemValue) {
        this.itemValue = itemValue;
    }

    @Override
    public String toString() {
        return "SearchItem{" + "itemId=" + itemId + ", itemValue='" + itemValue + '\'' + '}';
    }
}
