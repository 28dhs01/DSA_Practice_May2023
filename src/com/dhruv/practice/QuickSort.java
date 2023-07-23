package com.dhruv.practice;

import java.util.Arrays;
// the solution below is wrong
public class QuickSort {
    public static void main(String[] args) {
        int[] nums = {15,20,17,19} ;
        quickSort(nums,0,nums.length-1) ;
        System.out.println(Arrays.toString(nums));
    }
    static void quickSort(int[]nums , int lo, int hi ){
        if( lo < hi ){
            int pvtIdx = getPvtIdx(nums,lo,hi) ;
            System.out.println(pvtIdx) ;
            System.out.println(Arrays.toString(nums) );
            quickSort(nums,lo,pvtIdx-1);
            quickSort(nums,pvtIdx+1,hi);
        }
    }
    static int getPvtIdx(int[]nums,int lo , int hi){
        int pvtIdx = lo ;
        int pvt = nums[pvtIdx] ;
        int s = lo ;
        int e = hi ;
        while( s<e ){
            while( nums[s]<=pvt && s<=hi-1 ){
                s++ ;
            }
            while( nums[e]> pvt && e>=s+1 ){
                e-- ;
            }
            if( s<e ){
                swap(nums,s,e) ;
            }
        }
        swap(nums,pvtIdx,e);
        return e;
    }
    static void swap(int[] nums, int f ,int s ){
        int temp = nums[s] ;
        nums[s] = nums[f] ;
        nums[f] = temp ;
    }

}
