package com.dhruv.custom_ds;

import java.util.ArrayList;
import java.util.List;

public class Testing {
    public static void main(String[] args) {
        MyArrayList al = new MyArrayList() ;
        al.add(1);
        al.add(2);
        al.add(3);
        al.add(4);
        System.out.println(al);

        List<Object> list = new ArrayList<>() ;
        System.out.println(list);

    }
}
