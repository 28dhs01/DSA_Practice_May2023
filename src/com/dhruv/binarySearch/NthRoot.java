package com.dhruv.binarySearch;

public class NthRoot {
    public static void main(String[] args) {
        int ans = helper(9, 1953125) ;
        System.out.println(ans);
    }
    static int helper(int n, int m){
        int s = 1 ;
        int e = (int)Math.sqrt(m) ;
        while( s<=e ){
            int mid = s+(e-s)/2 ;
            long mul = mid ;
            for( int i = 1 ; i<n; i++ ){
                mul *= mid;
                if(mul>m){
                    break;
                }
            }

            if( mul == m ){
                return mid ;
            }
            if( mul>m ){
                e = mid-1 ;
            }else{
                s = mid+1 ;
            }
        }
        return -1 ;
    }
}
