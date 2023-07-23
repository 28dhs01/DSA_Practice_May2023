package com.dhruv.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
    public static void main(String[] args) {
        int[][] intervals = {
                {1,3},
                {2,6},
                {8,10},
                {15,18}
        } ;
        int[][] res = merge(intervals) ;
        for( int [] ar: res ){
            System.out.println(Arrays.toString(ar));
        }
    }
    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[0] -b[0]);
        List<List<Integer>> ansList = new ArrayList<>();
        for( int [] interval: intervals ){
            if( ansList.size() == 0 ){
                List<Integer> inList = new ArrayList<>();
                inList.add(interval[0]) ;
                inList.add(interval[1]) ;
                ansList.add(inList) ;
            }
            else if( interval[0] <= ansList.get(ansList.size()-1).get(1) ){
                List<Integer> inList = ansList.get(ansList.size()-1) ;
                inList.set(1,interval[1]) ;
            }else{
                List<Integer> inList = new ArrayList<>();
                inList.add(interval[0]) ;
                inList.add(interval[1]) ;
                ansList.add(inList) ;
            }
        }
        int[][] res = new int[ansList.size()][2] ;
        int i = 0 ;
        for( int[] ar: res ){
            ar[0] =  ansList.get(i).get(0) ;
            ar[1] = ansList.get(i).get(1) ;
            i++ ;
        }
        return res ;
    }
}
