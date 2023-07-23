package com.dhruv.graph_ds;

import java.util.ArrayList;
import java.util.Arrays;

public class FindPath {
    public static void main(String[] args) {
        int vtces = 7 ;
        ArrayList<Integer>[] graph = makeGraph(vtces);
        boolean [] visited = new boolean[vtces] ;
        String psf = "" ;
        findPath(graph,visited,0,6,psf) ;
        System.out.println(psf);
    }
    static void findPath(ArrayList<Integer>[]graph,boolean[]visited,int src, int dst, String psf){
        visited[src] = true ;
        if( src == dst ){
            psf+=src ;
            System.out.println(src+" via @ "+psf);
            return;
        }
        System.out.println(src+" via @ "+psf+src);
        for( int nbr: graph[src] ){
            if( visited[nbr] == false ){
                findPath(graph,visited,nbr,dst,psf+src);
            }
        }
    }
    static ArrayList<Integer>[] makeGraph(int vtces){
        ArrayList<Integer>[] graph = new ArrayList[vtces];
        for( int i = 0 ; i<vtces ; i++ ){
            graph[i] = new ArrayList<>();
        }
        graph[0].add(1);
        graph[0].add(3);
        graph[1].add(0) ;
        graph[1].add(2);
        graph[2].add(1);
        graph[2].add(3);
        graph[3].add(0);
        graph[3].add(4);
        graph[4].add(3);
        graph[4].add(5);
        graph[4].add(6);
        graph[5].add(4);
        graph[5].add(6);
        graph[6].add(4);
        graph[6].add(5);
//        for( int i = 0 ; i<vtces ; i++ ){
//            System.out.println(graph[i]);
//        }
        return graph ;
    }

}
