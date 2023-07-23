package com.dhruv.practice;

public class LongestSubstringWithoutRepeating {
    public static void main(String[] args) {
        int ans = lengthOfLongestSubstring("dvdf") ;
        System.out.println(ans);
    }
    public static int lengthOfLongestSubstring(String s) {
        int mxLen = 0 ;
        String sb = "" ;
        int i = 0;
        while( i<s.length() ){
            char ch = s.charAt(i) ;
            if( sb.contains(ch+"") ){
                mxLen = Math.max(mxLen,sb.length()) ;
                sb = "" ;
            }
            sb += ch ;
            i++ ;
        }
        mxLen = Math.max(mxLen,sb.length()) ;
        return mxLen ;
    }
}
