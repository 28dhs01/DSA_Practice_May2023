package com.dhruv.practice;

public class StringToInteger {
    public static void main(String[] args) {
        int x = myAtoi("+-12") ;
        System.out.println(x);
    }
    static int myAtoi(String s) {
        s = s.trim();
        boolean pos = true ;
        int idx = 0 ;
        if( s.charAt(idx) == '-' ){
            pos = false ;
        }
        int val = 0 ;
        for( int i = idx ; i<s.length() ; i++ ){
            int dgt = s.charAt(i) - '0' ;
            if( dgt<0 || dgt>9 ){
                break;
            }
            if( val>Integer.MAX_VALUE/10 ){
                if( pos ){
                    return Integer.MAX_VALUE ;
                }else{
                    return Integer.MIN_VALUE ;
                }
            }
            val*=10 ;
            val += dgt ;
        }
        if( !pos ){
            return -val ;
        }
        return val ;
    }
}
