package com.dhruv.company;

import java.util.ArrayList;
import java.util.Scanner;

public class BinaryStrings {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in) ;
        int n = sc.nextInt() ;
        sc.nextLine() ;
        String[] ar = new String[n] ;
        for( int i = 0 ; i<n ; i++ ){
            System.out.println("enter");
            ar[i] = sc.nextLine() ;
        }
        boolean[] visited = new boolean[ar.length] ;
        ArrayList<String> arrayList = new ArrayList<>();
        makePermutations(ar,visited,0,arrayList,"") ;
        System.out.println(arrayList);
        int ans = Integer.MIN_VALUE ;
        for(  int i = 0 ; i<arrayList.size() ; i++ ){
             ans = Math.max( cntPairs(arrayList.get(i)) ,ans )  ;
        }
        System.out.println(ans);
    }
    static void makePermutations(String[] ar, boolean[] visited , int curIdx, ArrayList<String> arrayList, String ssf){

//        if( curIdx == ar.length ){
//            arrayList.add(ssf) ;
//            return;
//        }
        boolean flag = true ;
        for( int i = 0 ; i< visited.length ; i++ ){
            if( visited[i] == true ){
                flag = false ;
            }
        }
        if( flag == true ){
            arrayList.add(ssf) ;
            return;
        }

        for( int i = 0 ; i<ar.length ; i++ ){
           if( visited[i] == false ){
               visited[i] = true ;
               String nssf = ssf+ar[i] ;
               makePermutations(ar,visited,i+1,arrayList,nssf);
               visited[curIdx] = false ;
           }
        }
    }
    static int cntPairs(String str){
        char [] chArr = str.toCharArray() ;
        int cnt = 0 ;
        for( int i = 0 ; i< chArr.length ; i++ ){
            for( int j = i+1 ; j< chArr.length ; j++ ){
                if( chArr[i] == '1' && chArr[j] == '0' ){
                    cnt++ ;
                }
            }
        }
        return cnt ;
    }
}
