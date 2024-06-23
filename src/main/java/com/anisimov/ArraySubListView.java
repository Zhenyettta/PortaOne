package com.anisimov;

import lombok.Data;

import java.util.ArrayList;

@Data
public class ArraySubListView {
    private ArrayList<Integer> list;
    private int start;
    private int end;

    public ArraySubListView(ArrayList<Integer> list) {
        this.list = list;
        this.start = 0;
        this.end = list.size();
    }

    public ArraySubListView(ArraySubListView view, int start, int end) {
        this.list = view.getList();
        this.start = view.start + start;
        this.end = view.start + end;
    }

    public Integer get(int index) {
        return list.get(start + index);
    }

    public void set(int index, int value) {
        list.set(start + index, value);
    }


    public int size() {
        return end - start;
    }

}
