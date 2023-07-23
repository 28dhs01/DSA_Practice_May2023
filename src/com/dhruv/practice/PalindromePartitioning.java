package com.dhruv.practice;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    public static void main(String[] args) {
        partition("aab") ;
    }
    public static List<List<String>> partition(String s) {
        List<List<String>>res = new ArrayList<>() ;
        List<String>inList = new ArrayList<>() ;
        makeList(res,inList,0,s) ;
        return res ;
    }
    static void makeList(List<List<String>> res, List<String> inList, int pos, String str){
        if( pos == str.length() ){
            List<String> dmy = new ArrayList<>(inList) ;
            res.add(dmy) ;
            return ;
        }
        for( int i = pos; i<str.length() ; i++ ){
            String sub = str.substring(pos,i+1) ;
            if( palin(sub) ){
                inList.add(sub) ;
                makeList(res,inList,i+1,str) ;
                inList.remove(inList.size()-1) ;
            }
        }
    }
    static boolean palin(String str){
        int lo = 0 ;
        int hi = str.length()-1 ;
        while( lo<=hi ){
            if( str.charAt(lo) != str.charAt(hi) ){
                return false ;
            }
            lo++ ;
            hi-- ;
        }
        return true ;
    }
}
