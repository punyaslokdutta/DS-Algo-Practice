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
    int ansMax;
    public int diameterOfBinaryTree(TreeNode root) {
        ansMax = 0;
        recur(root);
        return ansMax;
    }
    
    private int recur(TreeNode root)
    {
        if(root == null)
            return 0;
        int h =0;
        int l = recur(root.left);
        int r = recur(root.right);
        
        ansMax = Math.max(ansMax, l + r );
        return 1 + Math.max(l, r);
    }
    
    
}