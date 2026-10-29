public class Solution {
    public ListNode detectCycle(ListNode head) {
        HashSet<ListNode> hs = new HashSet<>();

        while(head != null) {
            if(hs.contains(head)) 
               return head;
            
            hs.add(head);
            head = head.next;    
        }

        return null;
    }
}