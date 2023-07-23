package com.dhruv.practice;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] nums = {5,3,4,1,2} ;
        bubbleSort(nums) ;
        System.out.println(Arrays.toString(nums));
    }
    private static void bubbleSort(int[] nums ){
        int n = nums.length ;
        boolean swapped ;
        for( int i = 0 ; i<n-1 ; i++ ){
            swapped = false ;
            for( int j = 0 ; j<n-1-i ; j++ ){
                if( nums[j] > nums[j+1] ){
                    swapped = true ;
                    swap(nums,j,j+1) ;
                }
            }
            if( !swapped ){
                break;
            }
        }
    }
    private static void swap(int[]nums, int f,int s ){
        int temp = nums[s] ;
        nums[s] = nums[f] ;
        nums[f] = temp ;
    }
}
