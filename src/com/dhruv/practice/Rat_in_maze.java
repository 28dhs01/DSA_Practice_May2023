package com.dhruv.practice;

import java.util.ArrayList;

public class Rat_in_maze {
    public static void main(String[] args) {
        int N = 4 ;
        int m[][] = {{1, 0, 0, 0},
            {1, 1, 0, 1},
            {1, 1, 0, 0},
            {0, 1, 1, 1}} ;
            ArrayList<String> list = findPath(m,N) ;
        System.out.println(list);
    }
    public static ArrayList<String> findPath(int[][] m, int n) {
        // Your code here
        boolean[][]vis= new boolean[n][n] ;
        ArrayList<String> list = new ArrayList<>();
        helper(list,"",m,0,0,vis) ;
        if( list.isEmpty() ){
            list.add("-1")  ;
        }
        return list;

    }
    static void helper( ArrayList<String> list, String s , int[][] ar , int r,int c,boolean[][]vis ){
        if( r<0 || c<0 || r>=ar.length || c>=ar.length || vis[r][c] == true || ar[r][c] == 0){
            return ;
        }
        if( r == ar.length-1 && c==ar[0].length-1 ){
            list.add(s) ;
            return ;
        }
        vis[r][c] = true ;
        helper(list,s+'L',ar,r,c-1,vis);
        helper( list,s+'D',ar,r+1,c,vis) ;
        helper(list,s+'R',ar,r,c+1,vis) ;
        helper(list,s+'U',ar,r-1,c,vis);
        vis[r][c] = false ;
    }
}
