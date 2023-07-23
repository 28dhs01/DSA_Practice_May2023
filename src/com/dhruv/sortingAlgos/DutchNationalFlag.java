package com.dhruv.sortingAlgos;

import java.util.Arrays;

public class DutchNationalFlag {
    public static void main(String[] args) {
        int[] nums = {2,0,1} ;
        sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
    public static void sortColors(int[] nums) {
        int n = nums.length ;
        int lo = 0 ;
        int mid = 0 ;
        int hi = n-1 ;
        while( mid<=hi ){
            switch( nums[mid] ){
                case 0 : {
                    swap(nums,mid,lo) ;
                    lo++ ;
                    mid++ ;
                    break;
                }
                case 1: {
                    mid++ ;
                    break;
                }
                case 2: {
                    swap(nums,mid,hi) ;
                    hi-- ;
                }

            }
        }

    }
    static void swap(int [] nums ,int f, int s){
        int temp = nums[f] ;
        nums[f] = nums[s] ;
        nums[s] = temp ;
    }
}
