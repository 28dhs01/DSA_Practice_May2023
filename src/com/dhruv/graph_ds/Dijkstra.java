package com.dhruv.graph_ds;

import java.util.*;

public class Dijkstra {
    public static void main(String[] args) {
        int V = 3, E = 3 ;
//        ArrayList<ArrayList<ArrayList<Integer>>>adj = new ArrayList<>(){
//            {{{1, 1}, {2, 6}}, {{2, 3}, {0, 1}}, {{1, 3}, {0, 6}}};
//
//        } ;
//        int S = 2 ;
//        int[] res = dijkstra(V,adj,S) ;
//        System.out.println(res);
    }
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
        // Write your code here
        List<Edge>[] graph = new ArrayList[V];
        for( int i = 0 ; i< graph.length; i++ ){
            graph[i] = new ArrayList<Edge>();
        }
        for( int i = 0 ;i<V ; i++ ){
            ArrayList<ArrayList<Integer>> innerList = adj.get(i) ;
            for( ArrayList<Integer> list: innerList ){
                graph[i].add(new Edge(i,list.get(0),list.get(1))) ;
            }
        }
        Queue<Pair> q = new PriorityQueue<>() ;
        q.add(new Pair(S,0));
        int [] res = new int[V] ;
        boolean[] vis = new boolean[V] ;
        while( !q.isEmpty() ){
            Pair peek = q.poll() ;
            int peekIdx = peek.src;
            int dis = peek.dis ;
//            r m* w a*
            if( vis[peekIdx] == true ){
                continue;
            }
            vis[peekIdx] = true ;
            res[peekIdx] = dis ;
            for( Edge e: graph[peekIdx] ){
                if( vis[e.nbr] == false ){
                    q.add(new Pair(e.nbr,dis+e.wt)) ;
                }
            }
        }
        return res ;
    }
    static class Pair implements Comparable<Pair>{
        int src ;
        int dis ;
        Pair(int src , int dis ){
            this.src = src ;
            this.dis = dis ;
        }

        @Override
        public int compareTo(Pair o) {
            return this.dis-o.dis;
        }
    }
    static class Edge{
        int src ;
        int nbr;
        int wt ;
        Edge(int src, int nbr, int wt){
            this.src = src ;
            this.nbr = nbr ;
            this.wt = wt ;
        }
    }
}
