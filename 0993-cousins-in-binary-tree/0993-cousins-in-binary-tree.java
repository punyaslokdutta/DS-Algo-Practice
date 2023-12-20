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
    TreeNode parX = null;
    TreeNode parY = null;
    int depthX = 0;
    int depthY = 0;
    private void getDepthAndParent(TreeNode root, int x, int y , int depth, TreeNode par){
        if(root == null) return;
        
        if(root.val == x){
            parX = par;
            depthX = depth;
        }
        else if(root.val == y){
            parY = par;
            depthY = depth;
        }else{
            getDepthAndParent(root.left, x, y, depth +1, root);
            getDepthAndParent(root.right, x, y, depth +1, root);
        }
        
    }
    public boolean isCousins(TreeNode root, int x, int y) {
        getDepthAndParent(root, x, y,0,null);
        return depthX == depthY && parX!=parY;
        
    }
}