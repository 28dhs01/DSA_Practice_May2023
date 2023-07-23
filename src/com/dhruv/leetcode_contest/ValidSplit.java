package com.dhruv.leetcode_contest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ValidSplit {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>() ;
        list.add(3);
        list.add(3);
        list.add(3);
        list.add(3);
        list.add(7);
        list.add(2);
        list.add(2);
        int ans = minimumIndex(list) ;
        System.out.println(ans);
    }
    static int minimumIndex(List<Integer> nums) {
        int ptAns = nums.get(0) ;
        int cnt = 0 ;
        int n = nums.size() ;
        for( int i = 0 ; i<n ; i++ ){
            if( nums.get(i) == ptAns ){
                cnt++ ;
            }else{
                cnt-- ;
                if( cnt == 0 ){
                    ptAns = nums.get(i) ;
                }
            }
        }
        if( cnt == 0 ){
            return -1 ;
        }
        int cntPtAns = getCnt(nums,0,n-1,ptAns) ;
        if( 2*cntPtAns<n){
            return -1 ;
        }
        for( int i = 0 ; i<n ; i++ ){
            int fst = getCnt(nums,0,i,ptAns) ;
            int scd = getCnt(nums,i,n-1,ptAns) ;
            if( fst*2 > i+1 && scd*2 > n-1-i ){
                return i ;
            }
        }
        return -1 ;
    }
    static int getCnt(List<Integer> list , int s , int e, int ptAns ){
        int cnt = 0 ;
        for( int i = s ; i<=e ; i++ ){
            if( list.get(i) == ptAns ){
                cnt++ ;
            }
        }
        return cnt ;
    }
}
