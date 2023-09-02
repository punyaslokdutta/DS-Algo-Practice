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
    List<String> ans;
    private void solve(TreeNode root , String temp)
    {
        if(root == null)return;
        temp+=root.val;
        if(root.left == null && root.right == null)
        {
            ans.add(new String(temp));
        }
        solve(root.left, temp + "->");
        solve(root.right, temp + "->");
        //temp.remove(temp.size()-1);
        
    }
    public List<String> binaryTreePaths(TreeNode root) {
        ans = new ArrayList<>();
        solve(root, "");
        return ans;
    }
}