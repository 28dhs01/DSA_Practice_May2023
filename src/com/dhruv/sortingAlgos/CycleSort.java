package com.dhruv.sortingAlgos;

import java.util.Arrays;

public class CycleSort {
    public static void main(String[] args) {
        int[] ar = {1,5,4,3,2} ;
        int curIdx = 0 ;
        while ( curIdx<ar.length ){
            int correctIdx = ar[curIdx] - 1 ;
            if( curIdx != correctIdx ){
                swap(ar,correctIdx,curIdx) ;
            }else{
                curIdx++ ;
            }
        }
        System.out.println(Arrays.toString(ar));
    }
    static void swap(int[]ar, int f , int s){
        int temp = ar[f] ;
        ar[f] = ar[s] ;
        ar[s] = temp ;
    }
}
