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
    public int countNodes(TreeNode root) {
        TreeNode l = root;
        TreeNode r = root;
        int hLeft = 0;
        int hRight = 0;
        while(l!=null)
        {
            hLeft++;
            l = l.left;
        } 
        while(r!=null)
        {
            hRight++;
            r = r.right;
        }
        if(hLeft == hRight) return (int)(Math.pow(2, hLeft) - 1);
        else return countNodes(root.left) + countNodes(root.right) + 1;
        
        
    }
}