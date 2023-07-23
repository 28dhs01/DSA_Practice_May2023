package com.dhruv.practice;

import java.util.Arrays;

public class InPlaceMergeSort {
    public static void main(String[] args) {
        int[] nums = {10,9,7,6,8,3,1,2} ;
        inplace(nums,0,nums.length-1) ;
        System.out.println(Arrays.toString(nums));
    }
    private static void inplace(int[] ar, int s, int e ){
        if( e-s == 0 ){
            return;
        }
        int m = s+(e-s)/2 ;
        inplace(ar,s,m);
        inplace(ar,m+1,e);
        merge(ar,s,m,e) ;
    }
    static void merge(int[]ar, int s, int m ,int e ){
        int[] merged = new int[e-s+1] ;
        int k = 0 ;
        int i = s ;
        int j = m+1;
        while( i<=m && j<=e ){
            if( ar[i] < ar[j] ){
                merged[k] = ar[i] ;
                i++ ;
            }else{
                merged[k] = ar[j] ;
                j++ ;
            }
            k++ ;
        }
        while( i<=m ){
            merged[k] = ar[i] ;
            i++ ;
            k++ ;
        }
        while( j<=e ){
            merged[k] = ar[j] ;
            j++ ;
            k++ ;
        }
        int z = 0 ;
        for( int l = s ; l<=e ; l++ ) {
            ar[l] = merged[z];
            z++ ;
        }
    }
}
