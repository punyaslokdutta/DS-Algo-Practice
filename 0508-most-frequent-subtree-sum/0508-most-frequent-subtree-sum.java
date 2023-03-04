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
    int maxCount = 0;
    Map<Integer, Integer> mp;
    public int[] findFrequentTreeSum(TreeNode root) {
        mp  = new HashMap<>();
        dfs(root);
        
        List<Integer> res = new ArrayList<>();
        for(int x : mp.keySet())
        {
            if(mp.get(x) == maxCount)
                res.add(x);
        }
        
        return res.stream().mapToInt(Integer -> Integer).toArray();   
    }
    
     private int dfs(TreeNode root)
    {
        if(root == null)
            return 0;
        int sumSubTree = dfs(root.left) + dfs(root.right) + root.val;
        mp.put(sumSubTree, mp.getOrDefault(sumSubTree, 0)+1);
        maxCount = Math.max(maxCount, mp.get(sumSubTree)); 
        return sumSubTree;
    }
   
}