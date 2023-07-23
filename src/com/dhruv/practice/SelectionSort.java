package com.dhruv.practice;

import com.dhruv.heap_ds.HeapSort;

import java.util.Arrays;


public class SelectionSort extends HeapSort {
    public static void main(String[] args) {
        int[] nums = {7,8,9,3,1,2} ;
        selectionSort(nums) ;
        System.out.println(Arrays.toString(nums));
    }
    private static void selectionSort(int[]nums){
        int n = nums.length ;
        for( int i = 0 ; i<n-1 ; i++ ){
            int lstIdx = n-1-i ;
            int mxIdx = 0 ;
            for( int j = 1 ; j<=n-1-i ;j++ ){
                if( nums[j]>nums[mxIdx] ){
                    mxIdx = j ;
                }
            }
            swap(nums,lstIdx,mxIdx) ;
        }
    }
}
