package com.dhruv.sortingAlgos;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[]ar = {6,2,7,1} ;
        int n = ar.length ;
        for( int i = 0 ; i<n-1; i++ ){
            boolean isSwapped = false ;
            for( int j = 0 ; j<n-1-i ; j++ ){
                if( ar[j] > ar[j+1] ){
                    isSwapped = true ;
                    swap(ar,j,j+1) ;
                }
            }
            if(!isSwapped){
                break;
            }
        }
        System.out.println(Arrays.toString(ar));
    }
    static void swap(int [] ar, int f , int s ){
        int temp = ar[f] ;
        ar[f] = ar[s] ;
        ar[s] = temp ;
    }
}
