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
    private TreeNode merge(TreeNode r1, TreeNode r2)
    {
        TreeNode root;
        if(r2 == null && r1 == null) return null;
        else if(r2 == null) return r1;
        else if(r1 == null) return r2;
        
        root = new TreeNode(r1.val + r2.val);
        root.left = merge(r1.left, r2.left);
        root.right = merge(r1.right, r2.right);
        return root;
        
    }
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        return merge(root1,  root2);
        
    }
}