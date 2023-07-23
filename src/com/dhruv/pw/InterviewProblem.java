package com.dhruv.pw;

import java.util.Arrays;

public class InterviewProblem {
    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 5} ;
        int[][]B = {{0, 3}, {1, 2}} ;
        int[] ans = helper(A,A.length,B,B.length) ;
        System.out.println(Arrays.toString(ans));
    }
    static int[] helper(int[]A, int n,  int[][]B, int m ){
        int[] res = new int[m] ;
        int[]pfxSum = new int[n] ;
        int sum = 0 ;
        for( int i = 0 ; i<n ; i++ ){
            sum += A[i] ;
            pfxSum[i] = sum ;
        }
        System.out.println(Arrays.toString(pfxSum));

        int ptr = 0 ;
        for( int[] ar: B ){
            int l = ar[0] ;
            int r = ar[1] ;
            int tempAns = pfxSum[r] ;
            if( l-1>=0 ){
                tempAns -= pfxSum[l-1] ;
            }
            res[ptr] = tempAns ;
            ptr++ ;
        }
        return res ;
    }
}
