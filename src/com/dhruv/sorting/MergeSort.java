package com.dhruv.sorting;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int N = 5 ;
        int[] arr = {4 ,1 ,3 ,9 ,7} ;
        mergeSort(arr,0,N-1);
        System.out.println(Arrays.toString(arr));
    }

    static void merge(int[] arr, int l, int m, int r)
    {
        // Your code here
        int i = l ;
        int j = m+1 ;
        int k = 0 ;
        int[] dmy = new int[r-l+1] ;
        while( i<=m && j<=r ){
            if( arr[i]<arr[j] ){
                dmy[k] = arr[i] ;
                i++ ;
            }else{
                dmy[k] = arr[j] ;
                j++ ;
            }
            k++ ;
        }
        while( i<=m ){
            dmy[k] = arr[i] ;
            i++ ;
            k++ ;
        }
        while( j<=r ){
            dmy[k] = arr[j] ;
            j++ ;
            k++ ;
        }
        System.out.println(Arrays.toString(dmy));
        int b = 0 ;
        for( int a = l ; a<=r ; a++ ){
            arr[a] = dmy[b] ;
            b++ ;
        }
    }
    static void mergeSort(int[] arr, int l, int r)
    {
        //code here
        if( r-l == 0 ){
            return ;
        }
        int m = l+(r-l)/2 ;
        mergeSort(arr,l,m) ;
        mergeSort(arr,m+1,r) ;
        merge(arr,l,m,r) ;
    }
}
