package com.dhruv.practice;

import java.util.Arrays;

public class MaxEvents {
    public static void main(String[] args) {
        int[][]events = {{1,2,4},{3,4,3},{2,3,1}};
        int k = 2 ;
        int res = maxValue(events,k) ;
        System.out.println(res);
    }
    static int maxValue(int[][] events, int k) {
        int n = events.length ;
        Arrays.sort(events, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        int[][]t = new int[n+1][k+1] ;
        for( int[]ar: t ){
            Arrays.fill(ar,-1) ;
        }
        return helper(events,n,k,0,t) ;
    }
    static int helper(int[][]events,int n, int k, int cur,int[][]t ){
        if( k==0 || cur>=n){
            return 0 ;
        }
        if( t[cur][k] != -1 ){
            return t[cur][k] ;
        }
        // 2 choices
        // take
        int rgtCur = n ;
        for( int i = cur+1 ; i<n ; i++ ){
            if( events[i][0] > events[cur][1] ){
                rgtCur = i ;
                break ;
            }
        }
        int ans1 = events[cur][2]+helper(events,n,k-1,rgtCur,t) ;
        // not take
        int ans2 = helper(events,n,k,cur+1,t) ;
        t[cur][k] = Math.max(ans1,ans2) ;
        return t[cur][k] ;
    }

}
