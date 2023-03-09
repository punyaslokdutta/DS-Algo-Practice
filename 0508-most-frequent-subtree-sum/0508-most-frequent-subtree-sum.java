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
    int maxFreq = 0;
    Map<Integer, Integer> mp;
    public int[] findFrequentTreeSum(TreeNode root) {
        mp = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        dfs(root);
        //traverse the map
        for(int x : mp.keySet())
        {
            if(mp.get(x) == maxFreq)
                res.add(x);
        }

        return res.stream().mapToInt(i-> i).toArray();
    }
    
    private int dfs(TreeNode root)
    {
        if(root == null )
            return 0;
        int subTreeSum = dfs(root.left) + dfs(root.right) + root.val;
        mp.put(subTreeSum, mp.getOrDefault(subTreeSum, 0) + 1);
        maxFreq = Math.max(maxFreq, mp.get(subTreeSum) );
        return subTreeSum;
    }

   
}