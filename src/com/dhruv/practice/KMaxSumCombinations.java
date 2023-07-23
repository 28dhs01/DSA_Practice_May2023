package com.dhruv.practice;

import java.lang.reflect.Array;
import java.util.*;

public class KMaxSumCombinations {
    public static void main(String[] args) {
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(1) ;
        list1.add(3);
        list1.add(5 );
        ArrayList<Integer> list2 = new ArrayList<>() ;
        list2.add(2);
        list2.add(4);
        list2.add(6);
        ArrayList<Integer> ans = kMaxSumCombination(list1,list2,3,3) ;
        System.out.println(ans);
    }
    public static ArrayList<Integer> kMaxSumCombination(ArrayList<Integer> a, ArrayList<Integer> b, int n, int k){
        // Write your code here.
        Collections.sort(a) ;
        Collections.sort(b) ;
        Set<String> set = new HashSet<>() ;
        PriorityQueue<Pair> mnh = new PriorityQueue<Pair>(new solComparator()) ;
        mnh.add(new Pair(n-1,n-1,a.get(n-1)+b.get(n-1))) ;
        set.add(n-1+" "+(n-1)) ;

        int i=n-1,j=n-1;
        int k1=k;
        ArrayList<Integer> list = new ArrayList<>();
        int y=0;

        for(int p1=0;p1<k;p1++){
            list.add(mnh.peek().sum);
            y++;

            i=mnh.peek().i1;
            j=mnh.peek().i2;
            mnh.poll();

            if(i>0&&j>0){
                if(!set.contains(new String((i-1)+" "+j))){
                    mnh.add(new Pair(i-1,j,a.get(i-1)+b.get(j)));
                    set.add(((i-1)+" "+j));


                }

                if(!set.contains(new String(i+" "+(j-1)))){
                    mnh.add(new Pair(i,j-1,a.get(i)+b.get(j-1)));

                    set.add(new String(i+" "+(j-1)));
                }


            }

        }

        return list;



    }

    static class Pair {
        int i1 ;
        int i2 ;
        int sum ;
        Pair(int idx1 , int idx2, int sum){
            this.i1 = idx1 ;
            this.i2 = idx2 ;
            this.sum =sum ;
        }

    }
    static class solComparator implements Comparator<Pair>{
        public int compare(Pair p1,Pair p2){

            if(p1.sum<p2.sum)
                return 1;
            else if(p1.sum>p2.sum)
                return -1;
            else
                return 0;
        }
    }

}
