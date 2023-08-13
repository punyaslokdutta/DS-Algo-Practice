class Solution {
    private static boolean solve(int index, int[]nums , int [] dp)
    {
        int n = nums.length;
        if(index >= n) return true;
        if(dp[index] == 0 ) return false;
        else if(dp[index] == 1) return true;
        
        boolean ans = false;
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
        if(ans) dp[index] = 1;
        else dp[index] = 0;
        return dp[index] == 1;
    }
    public boolean validPartition(int[] nums) {
        int n = nums.length;
        int [] dp = new int[n];
        Arrays.fill(dp , -1);
        return solve(0, nums, dp);
    }
}