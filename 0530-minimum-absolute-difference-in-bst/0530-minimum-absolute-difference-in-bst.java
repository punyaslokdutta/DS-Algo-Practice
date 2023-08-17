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
    Integer prev = null;
    public void dfs(TreeNode root)
    {
        if(root == null) return;
        dfs(root.left);
        if(prev!=null)
        {
            ans = Math.min(ans, root.val - prev);
        }
        prev = root.val;
        dfs(root.right);
    }
    public int getMinimumDifference(TreeNode root) {
        ans = Integer.MAX_VALUE;
        dfs(root);
        return ans;
    }
}