package com.goldenscent.layoutdesign.dummyData;

public class LeftColumnData {
    String name;
    int resId;
    boolean isSelected;

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public LeftColumnData(String name, int resId) {
        this.name = name;
        this.resId = resId;
        this.isSelected = false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }
}
