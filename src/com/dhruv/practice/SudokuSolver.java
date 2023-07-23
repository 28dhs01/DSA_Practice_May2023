package com.dhruv.practice;

import java.util.Arrays;

public class SudokuSolver {
    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {',','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        } ;
        solveSudoku(board) ;
    }
    static char[][]ans = new char[9][9] ;
    static void solveSudoku(char[][] board) {
        helper(board,0,0) ;
        board = ans ;
        for( char[]ar : board ){
            System.out.println(Arrays.toString(ar));
        }

    }
    static void helper(char[][]board, int ro, int col){
        if( ro >= 9  ){
            ans = new char[9][9];
            for( int i = 0 ;i<9 ; i++ ){
                for( int j = 0 ; j<9 ; j++ ){
                    ans[i][j] = board[i][j] ;
                }
            }
            return ;
        }
        if( col >= 9 ){
            helper(board,ro+1,0) ;
            return;
        }
        if( board[ro][col] == '.' ){
            for( int i = 1 ; i<=9 ; i++ ){
                    char val = (char) (i+'0') ;
                    board[ro][col] = val;
                    if( valid(board,val,ro,col ) ) {
                            helper(board,ro,col+1);
                    }
                    board[ro][col] = '.';
            }
        }else{
                helper(board,ro,col+1);
        }


    }
    static boolean valid( char[][]board , char val ,int ro, int col ){
        // check in row
        for( int i=0 ; i<9 ; i++ ){
            if( i!=col ){
                if( board[ro][i] == val ){
                    return false ;
                }
            }
        }
        // check in col
        for( int i = 0 ; i<9 ; i++ ){
            if( i!=ro ){
                if( board[i][col] == val ){
                    return false ;
                }
            }
        }
        // check in box
        int rs = 3*(ro/3) ;
        int re = rs+3 ;
        int cs = 3*(col/3) ;
        int ce = cs+3 ;
        for( int i = rs ; i<re ;i++ ){
            for( int j = cs ; j<ce ; j++ ){
                if( i!=ro && j!=col ){
                    if( board[i][j] == val ){
                        return false;
                    }
                }
            }
        }
        return true ;
    }
}
