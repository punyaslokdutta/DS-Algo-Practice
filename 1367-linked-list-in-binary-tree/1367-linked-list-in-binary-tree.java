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
        
        boolean ans = solve(head, root);
        if(root!= null && !ans)
        {
            ans |= isSubPath(head, root.left);
            ans |= isSubPath(head, root.right);
        }
        return ans;
        
    }
    
    private boolean solve(ListNode head , TreeNode root)
    {
        if(head == null)
            return true;
        if(root == null)
            return false;
        if(head.val == root.val)
            return solve(head.next, root.left)  || solve(head.next, root.right);
        return false;
        
    }
}
