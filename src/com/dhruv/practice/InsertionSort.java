package com.dhruv.practice;

import java.util.Arrays;

import static com.dhruv.heap_ds.HeapSort.swap;

public class InsertionSort {
    public static void main(String[] args) {
        int[] nums = {6,9,2,5,4,3} ;
        insertionSort(nums);
        System.out.println(Arrays.toString(nums));
    }
    static void insertionSort(int[]nums){
        int n = nums.length ;
        for( int i = 1 ; i<n ; i++ ){
            for( int j = i ; j>0 ; j-- ){
                if( nums[j] < nums[j-1] ){
                    swap(nums,j,j-1) ;
                }else{
                    break;
                }
            }
        }
    }
}
