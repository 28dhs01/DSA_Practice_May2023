package com.dhruv.binarySearch;

import java.util.Arrays;

public class AggressiveCows {
    public static void main(String[] args) {
        int[]stalls = {0,3,4,7,10,9} ;
        int cows = 4  ;
        int ans = aggressiveCows(stalls,cows) ;
        System.out.println(ans);
    }
    public static int aggressiveCows(int []stalls, int k) {
        //    Write your code here.

        Arrays.sort(stalls) ;
        return bs(stalls,k) ;
    }
    static int bs(int[]stalls, int k){
        int mx = Integer.MIN_VALUE ;
        int mn = Integer.MAX_VALUE ;
        for( int i = 0 ; i<stalls.length ; i++ ){
            mx = Math.max(mx,stalls[i]) ;
            mn = Math.min(mn,stalls[i]) ;
        }
        int s = 1 ;
        int e = mx-mn ;
        int ans = 0 ;
        while( s<=e ){
            int m = s+(e-s)/2 ;
            int cows = 1 ;
            int currentCowPosition = stalls[0];
            for( int i = 1 ;i<stalls.length ;i ++  ){
                if( stalls[i]-currentCowPosition >= m ){
                    cows++ ;
                    currentCowPosition = stalls[i] ;
                }
            }
            if( cows < k ){
                e = m-1 ;
            }else{
                ans = m ;
                s = m+1 ;
            }
        }
        return ans ;
    }
}
