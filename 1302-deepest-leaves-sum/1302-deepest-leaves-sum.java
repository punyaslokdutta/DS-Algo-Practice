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
    int maxH ;
    int ans;
    private void solve(TreeNode root , int h)
    {
        if(root == null) return;
        if(root.left == null && root.right == null)
        {
            if(h > maxH){
                maxH = h;
                ans=root.val;
            }
            else if(h == maxH) ans+=root.val;
            return;
        }
        solve(root.left, h+1);
        solve(root.right, h+1);
    }
    public int deepestLeavesSum(TreeNode root) {
        maxH = 0;
        solve(root, 0);
        return ans;
        
    }
}