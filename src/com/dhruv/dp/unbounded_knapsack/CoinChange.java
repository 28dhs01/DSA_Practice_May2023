package com.dhruv.dp.unbounded_knapsack;

import java.util.Arrays;
// wrong sol
public class CoinChange {
    public static void main(String[] args) {
        int[] coins = {1,2,5} ;
        int amount = 11 ;
        int ans = coinChange(coins,amount) ;
        System.out.println(ans);
    }
    static int coinChange(int[] coins, int amount) {
        int n = coins.length ;
        int[][] t = new int[n+1][amount+1] ;
        for( int[] ar: t ){
            Arrays.fill(ar,Integer.MAX_VALUE) ;
        }
        int ans = helper(coins,0,0,amount,0,t) ;
        for( int []ar: t ){
            System.out.println(Arrays.toString(ar));
        }
        if( ans == Integer.MAX_VALUE ){
            return -1 ;
        }
        return t[n][amount] ;
    }
     static int helper( int[]coins, int idx, int money, int amount, int cnt , int[][]t ){
         if( money>amount || idx>=coins.length ){
             return Integer.MAX_VALUE ;
         }
         if( money == amount ){
             return cnt ;
         }

         if ( t[idx+1][amount] != Integer.MAX_VALUE ){
             return t[idx+1][amount] ;
         }

         // 2 choices
         // pick
         int min = Integer.MAX_VALUE ;
         for( int i = idx ; i<coins.length ; i++ ){
             int cur = helper(coins,i,money+coins[i],amount,cnt+1,t) ;
             min = Math.min(cur,min) ;
         }
         // not pick
         int cur = helper(coins,idx+1,money,amount,cnt,t) ;
         t[idx+1][amount] =  Math.min(min,cur) ;
         return t[idx+1][amount] ;
     }
}
