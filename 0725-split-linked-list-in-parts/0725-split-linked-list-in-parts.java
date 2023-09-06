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
// class Solution {
//     public ListNode[] splitListToParts(ListNode head, int k) {
//         ListNode curr = head;
//         int count = 0;
//         while(curr!= null)
//         {
//             count++;
//             curr = curr.next;
//         }
//         ListNode[] ans = new ListNode[k];
//         int reqSize = count/k;
//         int numExtraNodesElems = count%k;
//         curr = head;
//         ListNode prev = null;
//         for(int i=0; curr!=null && i<k  ; i++, numExtraNodesElems--)
//         {
//             ans[i] = curr;
//             reqSize = reqSize + ((numExtraNodesElems > 0) ? 1: 0);
//             for(int j=0;j<reqSize;j++)
//             {
//                 prev = curr;
//                 curr = curr.next;
//             }
//             if(prev!= null)
//             {
//                 prev.next = null;
//             }
//             //numExtraNodesElems--;
//         }
        
        
//         return ans;
        
//     }
// }


class Solution {
    public ListNode[] splitListToParts(ListNode root, int k) {
        ListNode[] parts = new ListNode[k];
        int len = 0;
        ListNode node = root;
        while (node != null) {
            len++;
            node = node.next;
        }
        
        int n = len / k, r = len % k;
        node = root;
        ListNode prev = null;

        for (int i = 0; node != null && i < k; i++, r--) {
            parts[i] = node;
            for (int j = 0; j < n + (r > 0 ? 1 : 0); j++) {
                prev = node;
                node = node.next;
            }
            if (prev != null) {
                prev.next = null;
            }
        }
        return parts;
    }
}


//avoid cycles


// 1->2->3->4->5
//       ------|