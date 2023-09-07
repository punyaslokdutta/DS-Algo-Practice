class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        // Create a dummy node to simplify edge cases
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prevLeft = dummy;
        
        // Move 'prevLeft' to the node just before the 'left' position
        for (int i = 0; i < left - 1; ++i) {
            prevLeft = prevLeft.next;
        }
        
        // Initialize the current node within the sublist
        ListNode current = prevLeft.next;
        
        // Reverse the sublist from 'left' to 'right'
        for (int i = 0; i < right - left; ++i) {
            ListNode nextNode = current.next;
            current.next = nextNode.next;
            nextNode.next = prevLeft.next;
            prevLeft.next = nextNode;
        }
        
        // Return the modified linked list (skip the dummy node)
        return dummy.next;
    }
}