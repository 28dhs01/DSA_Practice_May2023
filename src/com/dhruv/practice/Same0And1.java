package com.dhruv.practice;

import java.util.HashMap;
import java.util.Map;

public class Same0And1 {
    public static void main(String[] args) {
        int[] nums = {0,1} ;
        findMaxLength(nums);
    }
    public static int findMaxLength(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>() ;
        int sum = 0 ;
        int ans = 0 ;
        map.put(0,-1) ;
        for( int i = 0 ; i<nums.length ; i++ ){
            if( nums[i] == 0 ){
                nums[i] = -1 ;
            }
            sum = sum+nums[i] ;
            int key = sum ;
            if( map.containsKey(key) ){
                int tempAns = i-map.get(key) ;
                ans = Math.max(ans,tempAns) ;
            }else{
                map.put(key,i) ;
            }
        }
        return ans ;
    }
}
