package com.dhruv.custom_ds;

import java.util.Arrays;

public class MyArrayList {
    int SIZE = 2 ;
    int[]ar = new int[SIZE] ;
    int curIdx = 0 ;
    void add(int num){
        if( curIdx == SIZE ){
            updateArrayList() ;
        }
        ar[curIdx] = num ;
        curIdx++ ;
    }
    void delete(int idx){
        if(idx>=ar.length){
            throw new RuntimeException("Index out of bound") ;
        }
        for( int i = idx;i<SIZE ; i++ ){
            ar[i] = ar[i+1] ;
        }
        curIdx-- ;

    }

    void updateArrayList(){
        SIZE = SIZE*2;
        int[]updatedArray = new int[SIZE] ;
        updatedArray = Arrays.copyOf(ar,updatedArray.length) ;
        ar = updatedArray ;
    }
}

