package com.dhruv.practice;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class MergeKSortedArrays {
    public static void main(String[] args) {

    }
    public static ArrayList<Integer> mergeKSortedArrays(ArrayList<ArrayList<Integer>> kArrays, int k)
    {
        // Write your code here.
        PriorityQueue<Triplet> mnh = new PriorityQueue<>() ;
        for( int i = 0 ; i<k ; i++ ){
            ArrayList<Integer> list = kArrays.get(i) ;
            Triplet obj = new Triplet(i,0,list.get(0));
            mnh.add(obj) ;
        }
        ArrayList<Integer> res = new ArrayList<>();
        while (!mnh.isEmpty()){
            Triplet peek = mnh.peek();
            int listNo = peek.listNo;
            int idx = peek.idx;
            int val = peek.val;
            ArrayList<Integer> list = kArrays.get(listNo) ;
            mnh.poll();
            res.add(val) ;
            if( idx+1<list.size() ){
                Triplet next = new Triplet(listNo, idx+1, list.get(idx+1) ) ;
                mnh.add(next) ;
            }

        }
        return res ;

    }
    static class Triplet implements Comparable<Triplet>{
        int listNo ;
        int idx ;
        int val ;
        Triplet(int listNo, int idx , int val){
            this.listNo = listNo ;
            this.idx = idx ;
            this.val = val ;
        }

        @Override
        public int compareTo(Triplet o) {
            if( this.val<o.val ){
                return -1 ;
            }
            if( this.val == o.val ){
                return 0 ;
            }
            return 1 ;
        }
    }
}
