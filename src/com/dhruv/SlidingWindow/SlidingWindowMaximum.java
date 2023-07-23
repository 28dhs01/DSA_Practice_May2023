package com.dhruv.SlidingWindow;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Queue;

public class SlidingWindowMaximum {
    public static void main(String[] args) {
        int[]nums = {1,3,-1,-3,5,3,6,7} ;
        int k = 3 ;
        int []rs = maxSlidingWindow(nums,k) ;
        System.out.println(Arrays.toString(rs));

    }
     static int[] maxSlidingWindow(int[] nums, int k) {
         int n = nums.length ;
         int[] res = new int[n-k+1] ;
         Deque<Integer> q = new ArrayDeque<>() ;
         for( int i = 0 ; i<k ; i++ ){
             while( !q.isEmpty() && nums[i] > nums[q.peekLast()] ){
                 q.pollLast();
             }
             q.offerLast(i) ;
         }
         res[0] = nums[q.peekFirst()];
         int ansIdx = 1 ;
         for( int i = k ; i<nums.length ; i++ ){
             if( !q.isEmpty() && i-q.peekFirst() >= k ){
                 q.pollFirst() ;
             }
             while( !q.isEmpty() && nums[i] >= nums[q.peekLast()] ){
                 q.pollLast();
             }
             q.offerLast(i) ;
             res[ansIdx] = nums[q.peekFirst()] ;
             ansIdx++ ;
         }

         return res ;
    }
}
