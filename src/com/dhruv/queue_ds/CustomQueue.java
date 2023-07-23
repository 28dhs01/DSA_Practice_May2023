package com.dhruv.queue_ds;

public class CustomQueue {
    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        System.out.println(queue);
        queue.remove();
        queue.add(2);
        queue.add(1);
        queue.add(6);
        queue.add(7);
        queue.displayQueue();
        queue.peek() ;
        queue.remove();
        queue.displayQueue();
        queue.peek();
        queue.add(8);
        queue.add(10);
        queue.add(22);
        queue.displayQueue();
    }
}
class MyQueue{
    private int peekPtr ;
    private int curPtr ;
    private int[] ar ;
    private int defaultSize = 5 ;
    MyQueue(){
        ar = new int[defaultSize] ;
        peekPtr = -1 ;
        curPtr = -1 ;
    }
    void add(int val){
        if( peekPtr == -1 ){
            peekPtr++ ;
        }
        if( isFull(ar,curPtr) ){
            int newDefSize = defaultSize*2 ;
            int[] temp = new int[newDefSize] ;
            for( int i = 0 ; i<defaultSize ; i++ ){
                temp[i] = ar[i] ;
            }
            ar = temp ;
            defaultSize = newDefSize ;
        }
        curPtr++ ;
        ar[curPtr] = val ;
    }

    private boolean isFull(int[] ar, int curPtr) {
        if( curPtr == ar.length-1 ){
            return true ;
        }
        return false ;
    }

    void remove(){
        if( curPtr == -1 ){
            System.out.println("queue is empty");
            return;
        }
        int [] dmy = new int[defaultSize] ;
        for( int i = 0 ; i<curPtr ; i++ ){
            dmy[i] = ar[i+1] ;
        }
        ar = dmy ;
        curPtr-- ;
    }
    int peek(){
        if( curPtr == -1 ){
            System.out.println("queue is empty");
            return -1 ;
        }
        return ar[peekPtr] ;
    }
    void displayQueue(){
        for( int i = 0 ; i<=curPtr ; i++ ){
            System.out.print(ar[i] +" ");
        }
        System.out.println();
    }

}
