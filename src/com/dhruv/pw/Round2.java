package com.dhruv.pw;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Round2 {
    public static void main(String[] args) {
        int ans = helper("hello my name is is dhruv", "is") ;
        System.out.println(ans);
    }
    static int helper(String str , String word ){

        int length = str.length() ;
        int ans = 0 ;
        int ptr = 0 ;
        StringBuilder sb = new StringBuilder() ;
        for( int i = str.length()-1 ; i>=0 ; i-- ){
            char ch = str.charAt(i) ;
            if( ch == ' ' ){
                sb = sb.reverse() ;
                String potAns = sb.toString();
                if( potAns.equals(word) ){
//                    i got the ans
                    ans = length-ptr;
                    break;
                }else{
                    ptr++ ;
                    sb = new StringBuilder();
                }
            }else{
                sb.append(ch) ;
                ptr++ ;
            }
        }
        return ans ;
    }
}
