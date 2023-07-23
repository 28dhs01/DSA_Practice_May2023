package com.dhruv.practice;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] nums = {10,9,7,6,8,3,1,2} ;
        int[] res = mergeSort(nums,0,nums.length-1) ;
        System.out.println(Arrays.toString(res));
    }
    private static int[] mergeSort(int[]nums,int s, int e){
        if( e-s == 0 ){
            return new int[]{nums[s]};
        }
        int m = s+(e-s)/2 ;
        int[] leftAr = mergeSort(nums,s,m) ;
        int[] rightAr = mergeSort(nums,m+1,e) ;
        return merge(leftAr,rightAr) ;
    }
    private static int[]merge(int []leftAr,int []rightAr){
        int[] merged = new int[leftAr.length+ rightAr.length] ;
        int i = 0 ;
        int j = 0 ;
        int k = 0 ;
        while( i<leftAr.length && j< rightAr.length){
            if( leftAr[i] <= rightAr[j] ){
                merged[k] = leftAr[i] ;
                i++ ;
            }else{
                merged[k] = rightAr[j] ;
                j++ ;
            }
            k++ ;
        }
        while( i<leftAr.length ){
            merged[k] = leftAr[i] ;
            i++ ;
            k++ ;
        }
        while( j<rightAr.length ){
            merged[k] = rightAr[j] ;
            j++ ;
            k++ ;
        }
        return merged ;
    }
}
