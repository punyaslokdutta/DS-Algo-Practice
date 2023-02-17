class Solution {
    public int subarraySum(int[] nums, int k) {
        int partialSum = 0;
        int r = 0;
        int ans = 0;
        Map<Integer, Integer> umap = new HashMap<>();
        umap.put(0, 1);
        while(r<nums.length)
        {
            partialSum+=nums[r++];
            if(umap.containsKey(partialSum - k))
            {
                ans+=umap.get(partialSum - k);
                
            }
            umap.put(partialSum, umap.getOrDefault(partialSum, 0)+1);
        }
        return ans;
        
    }
}