package com.dhruv.practice;

import java.util.ArrayList;
import java.util.List;
// this is not working on Leetcode
public class SafeState {
    public static void main(String[] args) {
        int[][] graph =
                {{},{0,2,3,4},{3},{4},{}} ;
        List<Integer> res = eventualSafeNodes(graph) ;
        System.out.println(res);
    }
    public static List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> lst = new ArrayList<>() ;
        int n = graph.length ;
        for( int i = 0 ; i<n ; i++ ){
            boolean[] vis = new boolean[n] ;
            boolean call = dfs(graph,vis,i,i) ;
            if( call == false ){
                lst.add(i) ;
            }
        }
        return lst ;
    }
    static boolean dfs(int[][] graph, boolean[]vis, int cur,int actual){
        if( cur == actual && vis[cur] == true ){
            return true ;
        }
        vis[cur] = true ;
        for( int el: graph[cur] ){
            boolean call = dfs(graph,vis,el,actual) ;
            if( call == true ){
                return true ;
            }
        }
        return false ;
    }
}
