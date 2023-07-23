package com.dhruv.linked_list_ds;

public class CycleDetect {
    public static void main(String[] args) {
        ListNode head = new ListNode(1) ;
//        ListNode cycleStart = new ListNode(3) ;
        ListNode temp = head ;
        for( int i = 2 ; i<=6 ; i++ ){
            temp.next = new ListNode(i) ;
            temp = temp.next ;
        }
        temp.next = head ;
        boolean isCycle = isCycle(head) ;
        System.out.println(isCycle);
        ListNode newCycleStart = startOfCycle(head) ;
        if( newCycleStart != null ){
            System.out.println(newCycleStart.val);
        }
    }
    static ListNode startOfCycle( ListNode head ){
        boolean isCycle = isCycle(head) ;
        if( isCycle == false ){
            return null ;
        }
        ListNode slow = head ;
        ListNode fast = head;
        do{
            slow = slow.next ;
            if( fast.next != null ){
                fast = fast.next.next ;
            }
        } while(slow != fast );
        ListNode nStart = head ;
        while( nStart != slow ){
            slow = slow.next ;
            nStart = nStart.next;
        }
        return slow ;
    }
    static boolean isCycle( ListNode head ){
        if( head == null || head.next == null ){
            return false ;
        }
        ListNode slow = head ;
        ListNode fast = head;
        do{
            slow = slow.next ;
            if( fast.next != null ){
                fast = fast.next.next ;
            }
        } while(slow != fast && fast != null && fast.next != null );
        if( fast == null || fast.next == null ){
            return false ;
        }
        return true ;
    }
}
class ListNode {
    int val ;
    ListNode next ;

    ListNode(int val){
        this.val = val ;
        this.next = null ;
    }

}
