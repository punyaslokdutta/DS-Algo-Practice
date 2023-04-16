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
    
    public int rob(TreeNode root) {
        Map<TreeNode, Integer> mp ;
        mp = new HashMap<>();
        int ans = recurse(root, mp);
        return ans;
    }
    
    private int  recurse(TreeNode root, Map<TreeNode,Integer> mp)
    {
        if(root == null)
            return 0;
        if(mp.containsKey(root))
            return mp.get(root);
        int leftGrandMax =0;
        int rightGrandMax =0;
        
        if(root.left!= null )
            leftGrandMax = recurse(root.left.left, mp) + recurse(root.left.right, mp);
        if(root.right!= null )
            rightGrandMax = recurse(root.right.left,mp) + recurse(root.right.right, mp);
        
        int ans = Math.max(root.val + leftGrandMax + rightGrandMax, 
                           recurse(root.left, mp)
 + recurse(root.right, mp)                          );
        mp.put(root, ans);
        return ans;
    }
}