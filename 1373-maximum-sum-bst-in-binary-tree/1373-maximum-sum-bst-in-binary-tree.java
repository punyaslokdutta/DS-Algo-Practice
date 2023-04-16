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
    int max;
    public int maxSumBST(TreeNode root) {
        max = 0;
        findMax(root);
        return max;
    }
    
    private int [] findMax(TreeNode root)
    {
        if(root == null)
            return new int[]{1, Integer.MIN_VALUE, Integer.MAX_VALUE, 0};
        
        int [] left = findMax(root.left);
        int [] right = findMax(root.right);
        int sum =0;
        boolean isBst = false;
        if(left[0]==1 &&
           right[0] == 1 && 
           root.val > left[1] && 
           root.val < right[2])
            isBst = true;
        sum = root.val + left[3] + right[3];
        if(isBst == true)
        {
            max = Math.max(max, sum);
            
        }
        
        return new int[]{isBst?1:0, Math.max(root.val, right[1]),
                             Math.min(root.val, left[2]), sum};
        
        
    }
}