package com.dhruv.practice;

import java.util.ArrayList;
import java.util.List;

public class JosephusProblem {
    public static void main(String[] args) {
        int ans = findTheWinner(6,5) ;
        System.out.println(ans);
    }
    public static int findTheWinner(int n, int k) {
        List<Integer> list = new ArrayList<>() ;
        for( int i = 0 ; i<n ; i++ ){
            list.add(i+1) ;
        }
        return helper(list,k,0) ;
    }
    static int helper(List<Integer> list, int k, int curIdx){
        if ( list.size() == 1 ){
            return list.get(0) ;
        }
        int rmvIdx = (curIdx+k-1)%list.size() ;
        list.remove(rmvIdx) ;
        return helper(list,k,rmvIdx) ;
    }
}
