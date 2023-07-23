package com.dhruv.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static void main(String[] args) {
        int[] nums = {-2,0,1,1,2} ;
        threeSum(nums) ;
    }
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums) ;
        List<List<Integer>> outerList = new ArrayList<>() ;
        for( int i = 0 ; i<nums.length ; i++ ){
            List<Integer> inList = new ArrayList<>() ;
            int s = i+1 ;
            int e = nums.length-1 ;
            while( s<e ){
                if( ( nums[s]+nums[e]+nums[i] ) == 0 ){
                    inList.add(nums[i]) ;
                    inList.add(nums[s]) ;
                    inList.add(nums[e]) ;
                    System.out.println("hi") ;
                    if( !outerList.contains(inList) ){
                        outerList.add(inList) ;
                    }
                    s++ ;
                    e-- ;
                    inList = new ArrayList<>() ;
                }
                else if( ( nums[s]+nums[e]+nums[i] ) > 0 ){
                    e-- ;
                }else{
                    s++ ;
                }
            }
        }
        return outerList;
    }
}
