package com.dhruv.practice;

import java.util.ArrayList;
import java.util.List;

public class Subarray_with_given_XOR {
    public static void main(String[] args) {
        int[]ar = {4,2,2,6,4} ;
        solve(ar,6) ;
    }
    public static int solve(int[] A, int B) {
        List<List<Integer>> outerList = new ArrayList<>() ;
        for( int i = 0 ; i<A.length ; i++ ){
            List<Integer> innerList = new ArrayList<>() ;

            for( int j = i ; j<A.length ; j++ ){
                innerList.add(A[j]) ;
                List<Integer> dmyList = new ArrayList<>(innerList) ;
                outerList.add(dmyList) ;
            }
        }
        int cnt = 0 ;
        for(List<Integer> list : outerList ){
            if( helper(list,B) ){
                System.out.println(list) ;

                cnt++ ;
            }
        }

        return cnt ;
    }
    static boolean helper(List<Integer> list , int B){
        int xor = 0 ;
        for( int i = 0 ; i<list.size() ; i++ ){
            xor ^= list.get(i) ;
        }
        return xor == B ;
    }
}
