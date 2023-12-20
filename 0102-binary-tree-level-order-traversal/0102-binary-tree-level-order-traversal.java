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
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
         List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;
        q.offer(root);
        while(!q.isEmpty()){
            List<Integer> sub = new ArrayList<>();
            int sz = q.size();
            while(sz-- > 0){
            TreeNode f = q.poll();
            if(f!=null)sub.add(f.val);
            if(f.left!=null) q.offer(f.left);
            if(f.right!=null) q.offer(f.right);
            }
            ans.add(sub);  
        }
        
        return ans;
        
    }
}