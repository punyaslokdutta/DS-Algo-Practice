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
    public ListNode reverse(ListNode head)
    {
        ListNode curr = head;
        ListNode prev = null;
        ListNode next = null;
        while(curr!=null)
        {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next; 
        }
        return prev;
        
    }
    public ListNode doubleIt(ListNode head) {
        ListNode head1 = reverse(head);
        int carry = 0;
        ListNode curr = head1;
        ListNode prev = null;
        while(curr!=null)
        {
            int val = curr.val;
            val = 2*val + carry ;
            curr.val = val%10;
            carry = val/10;
            prev = curr;
            curr = curr.next;
        }
        if(carry!=0)
        {
            prev.next = new ListNode(carry);
        }
        return reverse(head1);
    }
}