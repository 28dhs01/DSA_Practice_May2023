package com.dhruv.practice;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class TopKFrequent {
    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        int k = 2 ;
        topKFrequent(nums,k) ;
    }
    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>() ;
        for( int i = 0 ; i<nums.length ; i++ ){
            int key = nums[i] ;
            if( map.containsKey(key) ){
                map.put(key,map.get(key)+1) ;
            }else{
                map.put(key,1) ;
            }
        }
        System.out.println(map) ;
        int[] res = new int[k] ;
        PriorityQueue<Pair> pq = new PriorityQueue<>() ;
        for( int key: map.keySet() ){
            if( pq.size() < k ){
                pq.add(new Pair(key,map.get(key)));
            }else{
                if( map.get(key)>pq.peek().val ){
                    pq.poll() ;
                    pq.add(new Pair(key,map.get(key))) ;
                }
            }
        }
        for( int i = k-1 ; i>=0 ; i-- ){
            res[i] = pq.poll().key ;
        }
        return res ;
    }
    static class Pair implements Comparable<Pair>{
        int key ;
        int val ;
        Pair(int key, int val){
            this.key = key ;
            this.val = val ;
        }
        @Override
        public int compareTo(Pair o) {
            if( this.val<o.val ){
                return -1 ;
            }
            if( this.val == o.val ){
                return 0 ;
            }
            return 1 ;
        }
    }
}
