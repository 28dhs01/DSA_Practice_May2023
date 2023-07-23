package com.dhruv.practice;

public class GoodSubarrays {
    public static void main(String[] args) {
        int[] nums = {0,0,1} ;
        int ans = numberOfGoodSubarraySplits(nums) ;
        System.out.println(ans);
    }
    public static int numberOfGoodSubarraySplits(int[] nums) {
        int mod = 10000007 ;
        int res = 0 ;
        int cnt = 0 ;
        for( int num: nums ){
            if( num == 0 ){
                cnt++ ;
            }else{
                res = (res+cnt)%mod ;
                cnt =0 ;
            }
        }
        return res ;
    }
}
