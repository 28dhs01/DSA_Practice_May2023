package com.dhruv.heap_ds;

import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        int[] ar = {7,3,2,1,6,5} ;
        int n = ar.length ;
        for( int i = n/2 - 1 ; i>= 0 ; i-- ){
            heapify(ar,i,n);
        }
        System.out.println(Arrays.toString(ar));
        int lastIdx = n-1 ;
        while( lastIdx != 0 ){
            swap(ar,0,lastIdx);
            heapify(ar,0,lastIdx);
            lastIdx-- ;
        }
        System.out.println(Arrays.toString(ar));
    }
    static void heapify(int []ar, int curIdx, int n){
        int largestIdx = curIdx ;
        int leftIdx = curIdx*2 + 1;
        int rightIdx = curIdx*2 + 2 ;
        if( leftIdx < n && ar[leftIdx] > ar[largestIdx] ){
            largestIdx = leftIdx ;
        }
        if( rightIdx < n && ar[rightIdx] > ar[largestIdx] ){
            largestIdx = rightIdx ;
        }
        if( largestIdx != curIdx ){
            swap(ar,curIdx,largestIdx) ;
            heapify(ar,largestIdx,n);
        }
    }
     public static void swap(int[] ar, int f, int s){
        int temp = ar[f] ;
        ar[f] = ar[s] ;
        ar[s] = temp ;
    }
}
