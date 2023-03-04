class Solution {
    public int maxSubArray(int[] nums) {
        
        int [] dp = new int[nums.length];
        dp[0] = nums[0];
        int maxAns = Math.max(nums[0], Integer.MIN_VALUE);
        for(int i=1;i<nums.length;i++)
        {
            dp[i] = (dp[i-1]>0) ? nums[i] + dp[i-1]: nums[i];
            maxAns = Math.max(maxAns , dp[i]);
        }
        
        return maxAns;
        
    }
}