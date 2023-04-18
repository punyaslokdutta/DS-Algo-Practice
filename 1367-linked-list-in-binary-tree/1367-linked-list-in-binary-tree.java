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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isSubPath(ListNode head, TreeNode root) {
        boolean ans = false;
        ans = subPathHelper(head, root);
        if(ans!=true && root!= null)
        {
            ans |= isSubPath(head, root.left);
            ans |= isSubPath(head , root.right);
        }
        return ans;
    }
    
    private boolean subPathHelper(ListNode head , TreeNode root)
    {
        if(root == null && head!= null)
            return false;
        if(head == null)
            return true;
        
        if(root.val == head.val)
            return subPathHelper(head.next, root.left) ||
                      subPathHelper(head.next, root.right);
        return false;
        
    }
    
}