package com.dhruv.heap_ds;

import java.util.Arrays;

public class HeapifyAlgo {
    public static void main(String[] args) {
        int[]ar = {0,80,56,52,51,87} ;
        int heapSize = ar.length-1 ;
//        heapify -> it ensures to put the element at its correct position
//        leafNodes -> [heapSize/2 + 1 , heapSize]
//        nonLeafNodes -> [1,heapSize/2]
//        I need to process only non-leaf nodes
        for( int i = heapSize/2 ; i>0 ; i-- ){
            heapify(ar,i) ;
        }
        System.out.println(Arrays.toString(ar));
    }
    static void heapify(int[]ar, int idx){
        int parentIdx = idx ;
        int child1Idx = parentIdx*2 ;
        int child2Idx = parentIdx*2+1 ;
        while( ( child1Idx < ar.length && ar[parentIdx]>ar[child1Idx] ) || ( child2Idx<ar.length && ar[parentIdx]>ar[child2Idx] )){
            if( ar[child1Idx] < ar[child2Idx] ){
                swap(ar,child1Idx,parentIdx) ;
                parentIdx = child1Idx ;
            }else{
                swap(ar,child2Idx,parentIdx) ;
                parentIdx = child2Idx ;
            }
            child1Idx = parentIdx*2 ;
            child2Idx = parentIdx*2+1 ;
        }
    }
    static void swap(int[]ar, int f, int s){
        int temp = ar[f] ;
        ar[f] = ar[s] ;
        ar[s] = temp ;
    }
}
