package com.dhruv.sigmoid;

public class Round1 {
    public static void main(String[] args) {
        String str = "racecr" ;
        boolean isPalin = helper(str) ;
        System.out.println(isPalin);
    }
    static boolean helper(String str){
        int s = 0 ;
        int e = str.length()-1 ;
        while( s<=e ){
            char fst = str.charAt(s) ;
            char scd = str.charAt(e) ;
            if( fst != scd ) {
                return false ;
            }else{
                s++ ;
                e-- ;
            }
        }
        return true ;
    }
}
