package com.dhruv.practice;

public class CountAndSay {
    public static void main(String[] args) {
        countAndSay(4) ;
    }
    static String countAndSay(int n) {
        if( n==1 ){
            return "1" ;
        }
        String s = countAndSay(n-1) ;
        int cnt = 1 ;
        String cur = "" ;
        for( int i = 1 ; i<s.length() ; i++ ){
            if( s.charAt(i) == s.charAt(i-1) ){
                cnt++ ;
            }else{
                cur += cnt ;
                cur += s.charAt(i-1) ;
                cnt = 1  ;
            }
        }
        cur += cnt ;
        cur += s.charAt(s.length()-1) ;
        return cur ;
    }
}
