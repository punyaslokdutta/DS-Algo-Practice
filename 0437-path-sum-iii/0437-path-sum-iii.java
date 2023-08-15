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
    int count;
    private void solve(TreeNode root , int target, Long ps, Map<Long, Integer> mp)
    {
        if(root == null) return;
        ps+=root.val;
        if(mp.containsKey(ps - target)) count+=mp.get(ps - target);
        mp.put(ps, mp.getOrDefault(ps, 0) + 1);
        solve(root.left, target, ps , mp);
        solve(root.right, target , ps , mp);
        mp.put(ps, mp.get(ps) - 1);   
    }
    public int pathSum(TreeNode root, int targetSum) {
        Map<Long, Integer> mp = new HashMap<>();
        mp.put(0L, 1);
        count =0;
        solve(root , targetSum, 0L, mp);
        return count;
    }
}