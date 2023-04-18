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
// [isBST, smallest , largest, maxSum]
class Solution {
    int maxSum;
    public int maxSumBST(TreeNode root) {
        maxSum = 0;
        int[] temp = solve(root);
        return maxSum;
    }
    
    private int [] solve(TreeNode root)
    {
        if(root == null )
            return new int[]{1, Integer.MAX_VALUE, Integer.MIN_VALUE, 0};
        boolean isBST = false;
        int left[] = solve(root.left);
        int right[] = solve(root.right);
        if(left[0] == 1 &&  right[0] == 1)
        {
            if(root.val > left[2] && root.val < right[1])
            {
                maxSum = Math.max(maxSum, left[3] + right[3] + root.val);
                isBST = true;
            }
        }
        return new int[]{isBST?1:0 , Math.min(root.val, left[1]), Math.max(root.val, right[2]), left[3] + right[3] + root.val};
        
    }
}