package com.dhruv.practice;

import java.util.Arrays;
import java.util.Stack;

public class AsteroidCollision {
    public static void main(String[] args) {
        int[] astroids = {-2,-1,1,2} ;
        int[] res = asteroidCollision(astroids) ;
        System.out.println(Arrays.toString(res));
    }
    static int[] asteroidCollision(int[] asteroids) {
        int n = asteroids.length ;
        Stack<Integer> stk = new Stack<>() ;
        for( int i = 0 ; i<n ; i++ ){
            int cur = asteroids[i] ;
            if( stk.isEmpty() || cur>0 ){
                stk.push(cur) ;
                continue ;
            }
            // negative element comes
            while( !stk.isEmpty() && stk.peek()>0 && stk.peek() < Math.abs(cur) ){
                stk.pop() ;
            }
            if( !stk.isEmpty() && stk.peek() == Math.abs(cur) ){
                stk.pop() ;
            }
            else{
                if( stk.isEmpty() || stk.peek()<0 ){
                    stk.push(cur) ;
                }
            }
        }
        int[] res = new int[stk.size()] ;
        int ptr = res.length-1 ;
        while( !stk.isEmpty() ){
            res[ptr] = stk.pop() ;
            ptr-- ;
        }
        return res ;
    }
}
