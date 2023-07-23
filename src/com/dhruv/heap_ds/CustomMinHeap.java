package com.dhruv.heap_ds;

public class CustomMinHeap {
    public static void main(String[] args) {
        MinHeap mnh = new MinHeap();
        mnh.add(2);
        mnh.add(4);
        mnh.add(3);
        mnh.add(6);
        mnh.add(-1);
//        mnh.displayHeap();
//        mnh.add(-2);
        mnh.displayHeap();
        mnh.poll() ;
        mnh.displayHeap();
        mnh.poll() ;
        mnh.displayHeap();
    }
}
class MinHeap{
    private int size = 6 ;
    private int [] ar = new int[size];
    private int curIdx = 1 ;
    private int peekIdx = 1 ;
    void add(int val){
        if( curIdx >= ar.length ){
            System.out.println("heap is full");
            return;
        }
        int childIdx = curIdx ;
        if( childIdx == 1 ){
            ar[childIdx] = val ;
        }else{
            int parentIdx = childIdx/2 ;
            ar[childIdx] = val ;
            while( childIdx != 1 && ar[parentIdx] > ar[childIdx] ){
                swap(ar,parentIdx,childIdx) ;
                childIdx = parentIdx ;
                parentIdx = childIdx/2 ;
            }
        }
        curIdx++ ;
    }
    int poll(){
        if( curIdx == 1 ) {
            System.out.println("heap is empty");
            return -1;
        }
        int poll = ar[peekIdx] ;
        swap(ar,peekIdx,curIdx-1) ;
        ar[curIdx-1] = 0 ;
        curIdx-- ;
        int parentIdx = peekIdx ;
        int child1Idx = parentIdx*2 ;
        int child2Idx = parentIdx*2+1 ;
        while( ( child1Idx < curIdx && ar[parentIdx] > ar[child1Idx] ) || ( child2Idx < curIdx && ar[parentIdx] > ar[child2Idx] ) ){
            if( ar[child1Idx] < ar[child2Idx] ){
                swap(ar,parentIdx,child1Idx) ;
                parentIdx = child1Idx ;
                child1Idx = parentIdx*2 ;
                child2Idx = parentIdx*2+1 ;
            }else{
                swap(ar,parentIdx,child2Idx);
                parentIdx = child2Idx ;
                child1Idx = parentIdx*2 ;
                child2Idx = parentIdx*2 + 1 ;
            }
        }
        return poll ;
    }
    int peek() {
        if( curIdx == 1 ){
            System.out.println("heap is empty");
            return -1;
        }
        return ar[peekIdx] ;
    }
    void swap(int[]ar, int f, int s){
        int temp = ar[f] ;
        ar[f] = ar[s] ;
        ar[s] = temp ;
    }
    void displayHeap(){
        for( int i = 1 ;i<curIdx ;i++ ){
            System.out.print(ar[i]+" ");
        }
        System.out.println();
    }
}
