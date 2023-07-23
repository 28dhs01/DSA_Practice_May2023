package com.dhruv.graph_ds;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllPaths {
    public static void main(String[] args) {
        int vtces = 7 ;
        int[][] mat = {
                {1, 3},
                {0, 2},
                {1,3},
                {0,4},
                {3,5,6},
                {4,6},
                {4,5}
        };
//        for( int i = 0 ; i<mat.length ; i++ ){
//            System.out.println(Arrays.toString(mat[i]));
//        }
        List<Integer>[] graph = makeGraph(mat,vtces) ;
        boolean[] visited = new boolean[vtces];
        findAllPaths(graph,0,vtces-1,visited,0+"") ;
    }
    static void findAllPaths(List<Integer>[]graph, int src, int dst, boolean[]visited,String psf){
        if( src == dst ){
            visited[src] = true ;
            System.out.println(psf);
            visited[src] = false ;
            return;
        }
        visited[src] = true ;
        for( int nbr : graph[src] ){
            if( visited[nbr] == false ) {
                findAllPaths(graph, nbr, dst, visited,psf+nbr);
            }
        }
        visited[src] = false ;
    }
    static List<Integer>[] makeGraph(int[][]mat , int vtces){
        List<Integer>[] graph = new ArrayList[vtces] ;
        for( int i = 0 ; i<vtces ; i++ ){
            graph[i] = new ArrayList<>();
        }
        for( int i = 0 ; i<mat.length ; i++ ){
            for( int c = 0 ; c<mat[i].length;c++ ){
                graph[i].add(mat[i][c]) ;
            }
        }
//        for( List<Integer> list: graph ){
//            System.out.println(list);
//        }
        return graph ;
    }
}
