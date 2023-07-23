package com.dhruv.practice;

public class LinkedList {
    public static void main(String[] args) {
        LL ll = new LL() ;
        ll.add(2);
        ll.add(4);
        ll.add(6);
        ll.display();
        ListNode newHead = ll.revLL() ;
        ll.revDisplay(newHead);
    }

}
class LL{
    ListNode head = new ListNode(-1);
    ListNode temp = head ;
    void add(int val){
        ListNode node = new ListNode(val) ;
        temp.next = node ;
        temp = temp.next ;
    }
    void display(){
        ListNode t2 = head.next ;
        while( t2 != null ){
            System.out.print(t2.val +" ");
            t2 = t2.next ;
        }
        System.out.println();
    }
    ListNode revLL(){
        ListNode pres = head.next ;
        ListNode prev = null ;
        ListNode next = pres.next ;
        while (pres != null ){
            pres.next = prev ;
            prev = pres ;
            pres = next ;
            if( next != null ){
                next = next.next ;
            }
        }
        return prev ;
    }
    void revDisplay(ListNode head){
        ListNode tmp = head ;
        while( tmp != null ){
            System.out.print(tmp.val+" ");
            tmp = tmp.next ;
        }
    }
}
class ListNode{
    int val ;
    ListNode next ;
    ListNode(int val){
        this.val = val ;
    }
}
