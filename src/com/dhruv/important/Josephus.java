package com.dhruv.important;

import java.util.ArrayDeque;
import java.util.Queue;

public class Josephus {
    public static void main(String[] args) {
        int ans = findTheWinner(8,8) ;
        System.out.println(ans);
    }
    static int findTheWinner(int n, int k) {
        Queue<Integer> queue = new ArrayDeque<>() ;
        for( int i = 0 ; i<n ; i++ ){
            queue.add(i+1) ;
        }
        return helper(queue,k) ;
    }
    static int helper(Queue<Integer> queue , int k){
        if( queue.size() == 1 ){
            return queue.peek();
        }
        int ctr = k ;
        while(queue != null && ctr>0){
            int top = queue.poll() ;
            ctr-- ;
            if( ctr != 0 ){
                queue.add(top) ;
            }
        }
        return helper(queue,k) ;
    }
}
