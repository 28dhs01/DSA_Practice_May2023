package com.dhruv.sortingAlgos;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] ar = {10,7,8,6,1} ;
        int n = ar.length ;
        for( int i = 0 ; i<n-1 ; i++ ){
            int lastIdx = n-1-i ;
            int lgstIdx = findLargest(ar,0,lastIdx) ;
            swap(ar, lastIdx,lgstIdx) ;
        }
        System.out.println(Arrays.toString(ar));
    }
    static int findLargest(int[]ar, int s, int e){
        int lgstIdx = s ;
        for( int i = s+1 ; i<=e ; i++ ){
            if( ar[i] > ar[lgstIdx] ){
                lgstIdx = i ;
            }
        }
        return lgstIdx ;
    }
    static void swap(int[]ar, int f, int s){
        int temp = ar[f] ;
        ar[f] = ar[s] ;
        ar[s] = temp ;
    }
}
