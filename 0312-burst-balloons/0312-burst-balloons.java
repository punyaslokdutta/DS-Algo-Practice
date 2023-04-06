class Solution {
    public int maxCoins(int[] nums) {
        int []arr = new int[nums.length + 2];
        int n = 1;
        for(int x : nums)
        {
            if(x > 0)
                arr[n++] = x;
        }
        arr[0] = 1;
        arr[n++] = 1;
        int [][] dp = new int[n][n];
        return solve(dp, arr, 0, n-1);
        
    }
    
    private int solve(int [][]dp, int[]arr, int left, int right)
    {
        
        if(left+1 == right)
            return 0;
        if(dp[left][right] > 0)
            return dp[left][right];
        int ans = 0;
        // ith ballon is burst last
        // points gained when bursting the ith ballon last 
        // = arr[i] * arr[left] * arr[right] + the two recursive subparts
        for(int i = left + 1 ; i<right;i++)
        {
            ans = Math.max(ans, arr[i]*arr[left]*arr[right] + 
                          solve(dp, arr, left, i) + solve(dp, arr, i, right));
            
        }
        dp[left][right] = ans;
        return ans;
    }
}