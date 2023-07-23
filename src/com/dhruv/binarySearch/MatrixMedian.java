package com.dhruv.binarySearch;

import java.util.ArrayList;
import java.util.Collections;

public class MatrixMedian {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3) ;
        matrix.add(list) ;
        int ans = getMedian(matrix) ;
        System.out.println(ans);
    }
    public static int getMedian(ArrayList<ArrayList<Integer>> matrix)
    {
        // Write your code here.
        int s = 1 ;
        int e = Integer.MAX_VALUE;
        int m = matrix.size() ;
        int n = matrix.get(0).size();
        int x = (m*n)/2 ;
        while( s<=e ){
            int mid = s+(e-s)/2;
            int cnt = getCount(matrix,mid) ;
            if( cnt>x) {
                e = mid-1 ;
            }else if( cnt<=x ){
                s = mid+1 ;
            }
        }
        return s ;

    }
    static int getCount(ArrayList<ArrayList<Integer>>matrix,int target){
        int cnt = 0 ;
        for( ArrayList<Integer>list : matrix ){
            cnt += count(list,target) ;
        }
        return cnt ;
    }
    static int count(ArrayList<Integer>list,int target){
        int s = 0;
        int e = list.size()-1 ;
        while( s<=e ){
            int m = s+(e-s)/2 ;
            if( list.get(m)<=target ){
                s = m+1 ;
            }else{
                e = m-1 ;
            }
        }
        return s ;
    }
}
