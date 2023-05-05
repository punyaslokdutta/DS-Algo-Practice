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
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root , Long.MAX_VALUE, Long.MIN_VALUE);
    }
    
    private boolean isValidBST(TreeNode root, long maxVal, long minVal)
    {
        if(root == null )
            return true;
        if(root.val >= maxVal || root.val <= minVal) return false;
        return isValidBST(root.left, root.val , minVal) && isValidBST(root.right, maxVal, root.val);
    }
}