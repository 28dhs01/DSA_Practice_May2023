package com.dhruv.company;

public class Xor_Maximization {
    public static void main(String[] args) {
        int[] ar = {2,4,3,6} ;
        int k = 2 ;
        int x = 1 ;
        int xor = 0 ;
        for( int m = 0 ; m < ar.length ; m++ ){
            xor = ar[m] ^ xor ;
        }
        int res = Integer.MIN_VALUE ;
        int i = 0 ;
        int j = 0 ;
        int dmyxor = xor;
        while( j<ar.length ){
            while( j-i < k ){
                dmyxor = dmyxor^ar[j] ;
                dmyxor = dmyxor^( ar[j] - x) ;
                j++ ;
            }
            if( i-1 >=0 ){
                dmyxor = dmyxor^( ar[i-1]-x) ;
                dmyxor = dmyxor^ar[i-1] ;
            }
//            System.out.println(dmyxor);
            res = Math.max(dmyxor,res) ;
            i++ ;
        }
        System.out.println(res);
    }
}
