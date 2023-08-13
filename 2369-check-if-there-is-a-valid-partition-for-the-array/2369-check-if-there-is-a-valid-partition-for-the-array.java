class Solution {
    private static Boolean solve(int index, int[]nums , Boolean [] dp)
    {
        int n = nums.length;
        if(index >= n) return true;
        if(dp[index]!=null) return dp[index];
        
        Boolean ans = false;
        if(index + 1 < n && nums[index] == nums[index+1])
        {
            ans |= solve(index + 2, nums , dp);
        }
        if(index + 2 < n && nums[index] == nums[index + 1] && nums[index+2]== nums[index])
        {
            ans |= solve(index + 3, nums , dp);
        }
        if(index + 2 < n && nums[index] + 1 == nums[index +1] && nums[index+1] +1 == nums[index +2])
        {
            ans|=solve(index+3, nums, dp);
        }
        dp[index] = ans;
        return dp[index];
    }
    public boolean validPartition(int[] nums) {
        int n = nums.length;
        Boolean [] dp = new Boolean[n];
        return solve(0, nums, dp);
    }
}