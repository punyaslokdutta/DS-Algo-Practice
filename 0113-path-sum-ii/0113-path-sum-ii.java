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
    List<List<Integer>> ans;
    private void solve(TreeNode root , List<Integer> temp , int leftSum)
    {
        if(root == null) return;
        temp.add(root.val);
        leftSum = leftSum - root.val;
        if(root.left == null && root.right == null && leftSum == 0)
        {
            ans.add(new ArrayList<>(temp));
        }
        solve(root.left, temp , leftSum);
        solve(root.right, temp , leftSum); 
        temp.remove(temp.size() - 1);
        
    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        ans = new ArrayList<>();
        solve(root, new ArrayList<>(), targetSum);
        return ans;
    }
}