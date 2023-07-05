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
    private boolean solve(TreeNode root1, TreeNode root2)
    {
        if(root1 == null && root2 == null) return true;
        else if(root1!= null && root2== null) return false;
        else if(root1 == null && root2 !=null) return false;
        else if(root1.val!=root2.val) return false;
        
        return solve(root1.left, root2.right) && solve(root1.right, root2.left);
    }
    public boolean isSymmetric(TreeNode root) {
       if(root == null) return true;
        
        return solve(root.left, root.right);
    }
}