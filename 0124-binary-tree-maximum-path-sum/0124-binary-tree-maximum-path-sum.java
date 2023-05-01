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
    int ans;
    int dfs(TreeNode root)
    {
        if(root == null )
            return 0;
        int l = dfs(root.left);
        int r = dfs(root.right);
        ans = Math.max(ans, l+r+root.val);
        return Math.max(0, Math.max(l, r) + root.val);
    }
    public int maxPathSum(TreeNode root) {
        ans = Integer.MIN_VALUE;
        dfs(root);
        return ans;
        
    }
}