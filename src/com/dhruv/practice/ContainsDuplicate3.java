package com.dhruv.practice;

import java.util.Arrays;

public class ContainsDuplicate3 {
    public static void main(String[] args) {
        int[]nums = {1,2,1,1};
        int indexDiff = 1;
        int valueDiff = 0 ;
        boolean ans = containsNearbyAlmostDuplicate(nums,indexDiff,valueDiff);
        System.out.println(ans);
    }
    public static boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        int n = nums.length ;
        Pair[] ar = new Pair[n] ;
        for( int i = 0 ; i<n ; i++ ){
            ar[i] = new Pair(nums[i],i) ;
        }
        Arrays.sort(ar) ;
        for( int i = 0 ; i<ar.length ;i++ ){
            System.out.println(ar[i].val);
        }
        int i = 0 ;
        int j = 1 ;
        while( j<n ){
            Pair f = ar[i] ;
            Pair s = ar[j] ;
            if( Math.abs(f.val-s.val) > valueDiff ){
                i++ ;
                if( i==j ){
                    j++ ;
                }
            }else{
                if(Math.abs(f.idx-s.idx) <= indexDiff){
                    return true ;
                }
                j++ ;
                if(f.val == s.val ){
                    i++ ;
                }
            }
        }
        return false ;
    }
    static class Pair implements Comparable<Pair>{
        int val ;
        int idx ;
        Pair(int val, int idx){
            this.val = val ;
            this.idx = idx ;
        }
        @Override
        public int compareTo(Pair other) {
            return this.val-other.val;
        }
    }
}
