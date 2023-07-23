package com.dhruv.dp;

import java.util.Arrays;

public class MCM {
    public static void main(String[] args) {
        int [] ar = {20,30,10,30} ;
        int ans = matrixMultiplication(3,ar) ;
        System.out.println(ans);
    }
    static int matrixMultiplication(int N, int[] arr)
    {
        // code here
        int[][] t = new int[N+1][N+1] ;
        for( int[] ar: t ){
            Arrays.fill(ar,-1) ;
        }
        return helper(arr,1,arr.length-1,t) ;

    }
    static int helper( int[] arr,  int i , int j, int[][]t ){
        if( i>=j ){
            return 0 ;
        }
        //
        if( t[i][j] != -1 ){
            return t[i][j] ;
        }
        int mn = Integer.MAX_VALUE ;
        for( int k = i ; k<j ; k++ ){
            int tempAns = helper(arr,i,k,t) + helper(arr,k+1,j,t) + arr[i-1]*arr[k]*arr[j] ;
            if( tempAns < mn ){
                mn = tempAns ;
            }
        }
        t[i][j] = mn ;
        return t[i][j] ;
    }
}
