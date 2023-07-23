package com.dhruv.game;

import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        char[][] board = new char[3][3] ;
        for( int row = 0 ; row< board.length ; row++ ){
            for( int col = 0 ; col < board[0].length ;col++ ){
                board[row][col] = ' ' ;
            }
        }
        boolean gameOver = false ;
        Scanner sc = new Scanner(System.in) ;
        System.out.println("enter player1 name");
        String player1 = sc.nextLine() ;
        System.out.println("enter player2 name");
        String player2 = sc.nextLine() ;
        String curPlayer = player1 ;
        int ctr = 0 ;
        while(!gameOver && ctr<9 ){
            printBoard(board) ;
            System.out.println(curPlayer +", enter your input");
            int ro = sc.nextInt() ;
            int col = sc.nextInt();
            if ( board[ro][col] != ' ' ){
                System.out.println("Invalid Input ! Try Again !");
                continue;
            }else{
                if( curPlayer == player1 ){
                    board[ro][col] = 'o' ;
                }else{
                    board[ro][col] = 'x' ;
                }
                boolean winner = checkWinner(board) ;
                if( winner == true ){
                    printBoard(board);
                    System.out.println(curPlayer +" wins the game ");
                    return;
                }
            }
            if( curPlayer == player1 ){
                curPlayer = player2 ;
            }else{
                curPlayer = player1 ;
            }
            ctr++ ;
        }
        if( ctr == 9 ){
            printBoard(board);
            System.out.println("It's a draw");
        }
    }
    static boolean checkWinner(char[][]board){
        if( board[0][0] == 'x' && board[1][1] == 'x' && board[2][2] == 'x' ){
            return true ;
        }
        if( board[0][0] == 'x' && board[0][1] == 'x' && board[0][2] == 'x' ){
            return true ;
        }
        if( board[1][0] == 'x' && board[1][1] == 'x' && board[1][2] == 'x' ){
            return true ;
        }
        if( board[2][0] == 'x' && board[2][1] == 'x' && board[2][2] == 'x' ){
            return true ;
        }
        if( board[0][0] == 'x' && board[1][0] == 'x' && board[2][0] == 'x' ){
            return true ;
        }
        if( board[0][1] == 'x' && board[1][1] == 'x' && board[2][1] == 'x' ){
            return true ;
        }
        if( board[0][2] == 'x' && board[1][2] == 'x' && board[2][2] == 'x' ){
            return true ;
        }


        if( board[0][0] == 'o' && board[1][1] == 'o' && board[2][2] == 'o' ){
            return true ;
        }
        if( board[0][0] == 'o' && board[0][1] == 'o' && board[0][2] == 'o' ){
            return true ;
        }
        if( board[1][0] == 'o' && board[1][1] == 'o' && board[1][2] == 'o' ){
            return true ;
        }
        if( board[2][0] == 'o' && board[2][1] == 'o' && board[2][2] == 'o' ){
            return true ;
        }
        if( board[0][0] == 'o' && board[1][0] == 'o' && board[2][0] == 'o' ){
            return true ;
        }
        if( board[0][1] == 'o' && board[1][1] == 'o' && board[2][1] == 'o' ){
            return true ;
        }
        if( board[0][2] == 'o' && board[1][2] == 'o' && board[2][2] == 'o' ){
            return true ;
        }
        return false ;
    }
    static void printBoard(char[][] board){
        for( int row = 0 ; row<board.length ; row++ ){
            for(int col = 0 ; col<board[row].length ; col ++ ){
                System.out.print(board[row][col] +" | ");
            }
            System.out.println();
        }
    }

}
