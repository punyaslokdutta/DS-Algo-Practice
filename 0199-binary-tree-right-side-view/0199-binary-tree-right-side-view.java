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
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null)
            return new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        Queue<TreeNode> q =new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty())
        {
            int size= q.size();
            for(int i= 0;i<size;i++)
            {
                TreeNode f = q.poll();
                
                if(f.left != null)
                    q.offer(f.left);
                if(f.right != null)
                    q.offer(f.right);
                if(i == size -1)
                    ans.add(f.val);
            }
            
        }
        return ans;
         
    }
}