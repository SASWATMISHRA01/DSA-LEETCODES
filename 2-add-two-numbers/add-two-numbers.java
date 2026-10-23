/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p1 = l1;
        ListNode p2 = l2;

        int C = 0;
        
        ListNode h = null , Curr = null;
        
        while((p1 != null) && (p2 != null)) {
           int add = p1.val + p2.val + C;

            if(add >= 10) {
              C = 1;
              add = add % 10;
            } else 
              C = 0;

            if(h == null) {
                h = new ListNode(add);
                Curr = h;
            } else {
                Curr.next = new ListNode(add);
                Curr = Curr.next;
            }

            p1 = p1.next;
            p2 = p2.next;
        }

        while(p1 != null) {
            int add = p1.val + C;

            if(add >= 10) {
              C = 1;
              add = add % 10;
            } else 
              C = 0;

            if(h == null) {
                h = new ListNode(add);
                Curr = h;
            } else {
                Curr.next = new ListNode(add);
                Curr = Curr.next;
            } 

            p1 = p1.next;         
        }

        while(p2 != null) {
            int add = p2.val + C;

            if(add >= 10) {
              C = 1;
              add = add % 10;
            } else 
              C = 0;

            if(h == null) {
                h = new ListNode(add);
                Curr = h;
            } else {
                Curr.next = new ListNode(add);
                Curr = Curr.next;
            } 

            p2 = p2.next;         
        }  

        if(C > 0) 
          Curr.next = new ListNode(1);

        return h;        
    }
}