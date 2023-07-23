package com.dhruv.sortingAlgos;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] ar = {2,7,1,10,3} ;
        int n = ar.length ;
        for( int i = 1 ; i<n ; i++ ){
            for( int j = i ; j>0 ; j-- ){
                if( ar[j] < ar[j-1] ){
                    swap(ar,j,j-1) ;
                }else{
                    break;
                }
            }
        }
        System.out.println(Arrays.toString(ar));
    }
    static void swap(int[] ar , int f, int s){
        int temp = ar[f] ;
        ar[f] = ar[s] ;
        ar[s] = temp ;
    }
}
