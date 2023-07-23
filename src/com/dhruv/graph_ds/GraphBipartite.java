package com.dhruv.graph_ds;

import java.util.ArrayDeque;
import java.util.Queue;

public class GraphBipartite {
    public static void main(String[] args) {
        int[][]graph = {{1,3},{0,2},{1,3},{0,2}};
        isBipartite(graph);
    }
    public static boolean isBipartite(int[][] graph) {
        int v = graph.length ;
        boolean[] vis = new boolean[v] ;
        boolean cycleFound = false ;
        for( int i=0 ;i<v ; i++ ){
            if( vis[i] == false ){
                System.out.println("i");
                if( isCyclic(graph,vis,i) ){
                    cycleFound = true ;
                    break ;
                }
            }
        }
        if( cycleFound == false ){
            return true ;
        }
        Pair2[] p2 = new Pair2[v] ;
        for( int i = 0 ; i<v ;i++ ){
            p2[i] = new Pair2(false,true) ;
        }
        for( int i = 0 ; i<v; i++ ){
            if( p2[i].vis == false ){
                boolean odd = oddCycle( graph,p2,i );
                if (odd==true){
                    return false ;
                }
            }
        }
        return true;

    }
    static boolean oddCycle(int[][] graph, Pair2[] p2, int src){
        Queue<Pair> q = new ArrayDeque<>() ;
        q.add(new Pair(src,true)) ;
        while( !q.isEmpty() ){
            Pair peek = q.peek();
            int node = peek.node ;
            boolean lvl = peek.lvl ;
            q.poll() ;
            if( p2[node].vis == true ){
                if(p2[node].lvl != lvl ){
                    return true ;
                }
                continue ;
            }
            p2[node] = new Pair2(true,lvl) ;
            for( int nbr: graph[node] ){
                q.add(new Pair(nbr,!lvl)) ;
            }
        }
        return false ;
    }
    static class Pair2{
        boolean vis ;
        boolean lvl ;
        Pair2(boolean vis, boolean lvl){
            this.vis= vis ;
            this.lvl = lvl ;
        }
    }
    static class Pair{
        int node ;
        boolean lvl ;
        Pair(int node, boolean lvl ){
            this.node = node ;
            this.lvl = lvl ;
        }
    }
    static boolean isCyclic(int[][] graph, boolean[] vis, int src){
        Queue<Integer> q = new ArrayDeque<>() ;
        q.add(src) ;
        while( !q.isEmpty() ){
            int peek = q.peek() ;
            System.out.println(peek) ;
            q.poll() ;
            if( vis[peek] == true ){
                // cycle found
                return true ;
            }
            vis[peek] = true ;
            for( int nbr: graph[peek] ){
                if( vis[nbr] == false ){
                    q.add(nbr) ;
                }
            }
        }
        return false ;
    }
}
