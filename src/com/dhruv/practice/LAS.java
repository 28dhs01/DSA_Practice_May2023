package com.dhruv.practice;

import java.util.ArrayList;
import java.util.List;

public class LAS {
    public static void main(String[] args) {
        int[]ar = {1,2,3,4};
        int difference = 1 ;
        longestSubsequence(ar,difference);
        System.out.println(ans);
    }
    static int ans = 0 ;
    public static int longestSubsequence(int[] arr, int difference) {
        int n = arr.length ;
        List<Integer> lst = new ArrayList<>() ;
        helper(arr,difference,lst,n-1) ;
        return ans ;
    }
    static void helper(int[] ar, int dif, List<Integer> lst, int cur){
        if( cur<0 ){
            int x = lst.size() ;
            ans = Math.max(ans,x) ;
            return ;
        }
        // 2 possible scenarios
        // empty list

        if( lst.size() == 0 ){
            lst.add(ar[cur]) ;
            helper(ar,dif,lst,cur-1) ;
            lst.remove(lst.size()-1) ;
            helper(ar,dif,lst,cur-1) ;
        }

        // else
        else{
            int val = lst.get( lst.size()-1 ) ;
            if( val - ar[cur]  == dif ){
                lst.add(ar[cur]) ;
                helper(ar,dif,lst,cur-1) ;
                lst.remove(lst.size()-1) ;
            }else{
                helper(ar,dif,lst,cur-1) ;
            }
        }
    }
}
