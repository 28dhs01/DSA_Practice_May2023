package com.dhruv.stack_ds;

public class CustomStack {
    public static void main(String[] args) {
        MyStack stk = new MyStack(5) ;
        stk.push(1);
        stk.push(2);
        stk.push(3);
        stk.displayStack();
        stk.pop();
        System.out.println(stk.peek());
        stk.push(4);
        stk.push(5);
        stk.push(6);
        stk.push(7);
        stk.displayStack();
        System.out.println(stk.peek());
    }
}
class MyStack{
    private int[] ar ;
    private int cur ;
    MyStack(int len){
        ar = new int[len] ;
        cur = -1 ;
    }
    void push(int val) {
        if( cur == ar.length-1 ){
            System.out.println("stack is full");
            return;
        }
        cur++ ;
        ar[cur] = val ;
    }
    void pop(){
        if( cur == -1 ){
            System.out.println("stack is empty");
            return;
        }
        ar[cur] = 0 ;
        cur-- ;
    }
    void displayStack(){
        for( int i = 0 ; i<=cur ; i++ ){
            System.out.print(ar[i] +" ");
        }
        System.out.println();
    }
    int peek(){
        return ar[cur] ;
    }
}
