package com.dhruv.practice;

public class NumberOfSquares {
    public static void main(String[] args) {

        cntSquares(10) ;
    }
    static int cntSquares(int n){
        int ans = ( n*(n+1)*(2*n+1) )/6 ;
        return ans ;
    }
}
