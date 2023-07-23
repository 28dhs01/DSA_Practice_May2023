package com.dhruv.stack_ds;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

// the below solution is wrong

public class MountainShaving {
    public static void main(String[] args) {
        String seq = "()(())()" ;
        int[] ans = maxDepthAfterSplit(seq) ;
        System.out.println(Arrays.toString(ans));
    }
    public static int[] maxDepthAfterSplit(String seq) {
        int[] res = new int[seq.length()] ;
        int lvl1 = 0 ;
        int lvl2 = 0 ;
        Stack<Character> stk = new Stack<>() ;
        for( int i = 0 ; i<seq.length() ; i++ ){
            if( seq.charAt(i) == '(' ){
                if(  Math.abs(  lvl1-lvl2  ) >= 1  ){
                    lvl2++ ;
                    res[i] = 1 ;
                }else{
                    lvl1++ ;
                    res[i] = 0 ;
                }
                stk.push('(') ;
            }else{
                stk.pop() ;
                if( stk.isEmpty()   ){
                    res[i] = 0 ;
                    lvl2-- ;
                }else{
                    res[i] = 1 ;
                    lvl1-- ;
                }
            }
        }
        return res ;
    }
}
