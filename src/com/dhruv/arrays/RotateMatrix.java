package com.dhruv.arrays;

import java.util.Arrays;

public class RotateMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        } ;
        rotate(matrix);
        for( int[] r: matrix ){
            System.out.println(Arrays.toString(r));
        }
    }
    public static void rotate(int[][] matrix) {
        int n = matrix.length ;
        // get the transpose
        for( int r = 0 ; r<n ; r++ ){
            for( int c = r ; c<n ; c++ ){
                swap(matrix,r,c) ;
            }
        }
        // swap ele of every row
        for( int [] r: matrix ){
            swapR(r) ;
        }
    }
    static void swap(int[][] matrix, int r, int c){
        int temp = matrix[r][c] ;
        matrix[r][c] = matrix[c][r] ;
        matrix[c][r] = temp ;
    }
    static void swapR(int[] r){
        int s = 0 ;
        int e = r.length-1 ;
        while( s<=e ){
            int temp = r[s] ;
            r[s] = r[e] ;
            r[e] = temp ;
            s++ ;
            e-- ;
        }
    }
}
