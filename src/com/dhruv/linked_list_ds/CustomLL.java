package com.dhruv.linked_list_ds;

public class CustomLL {
    public static void main(String[] args) {
        MyLL ll = new MyLL() ;
        ll.add(1);
        ll.add(2);
        ll.add(5);
        ll.displayLL();
        ll.add(4);
        ll.add(3);
        ll.displayLL();
        ll.add(3,17);
        ll.displayLL();
        ll.delete(2);
        ll.displayLL();
    }
}
class MyLL {
    Node mainHead = new Node(-1) ;
    Node temp = mainHead ;
    void add(int val){
        Node node = new Node(val) ;
        temp.next = node ;
        temp = node ;
    }
    void displayLL(){
        Node t2 = mainHead.next ;
        while (t2 != null ){
            System.out.print(t2.val +" ");
            t2 = t2.next ;
        }
        System.out.println();
    }
    void add(int idx, int val){
        Node temp = mainHead.next ;
        for( int i = 1 ; i<idx ; i++ ){
            temp = temp.next ;
        }
        Node newNode = new Node(val) ;
        newNode.next = temp.next ;
        temp.next = newNode ;
    }
    void delete(int idx){
        Node temp = mainHead.next ;
        for( int i = 1 ;i<idx ; i++ ){
            temp = temp.next ;
        }
        temp.next = temp.next.next ;
    }
}
class Node{
    int val ;
    Node next ;
    Node(int val){
        this.val = val ;
    }
}
