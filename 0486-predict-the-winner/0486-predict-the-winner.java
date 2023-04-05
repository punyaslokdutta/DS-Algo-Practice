class Solution {
    private int predict(int [][]dp, int[]nums, int turn,int start, int end)
    {
        if(start > end )
            return 0;
        if(dp[start][end] != -1)
            return dp[start][end]; 
        if(turn == 1)
        {
            //player one plays optimally 
            return dp[start][end] = Math.max(nums[start] +
                                             predict(dp, nums, 2, start+1, end), 
                           nums[end] + predict(dp, nums, 2, start, end -1));
        }
        else{
            
             return dp[start][end] = Math.min(predict(dp, nums, 1, start+1, end), 
                           predict(dp, nums, 1, start, end -1));
        }
    }
    public boolean PredictTheWinner(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n];
        int sum = 0;
        int sumOne = 0;
        int sumTwo = 0;
         for(int i=0;i<n;i++){
            sum+=nums[i];
            Arrays.fill(dp[i],-1);
        }
        sumOne = predict(dp, nums, 1, 0, n - 1);
        sumTwo = sum - sumOne;
        return (sumOne>=sumTwo);
        
        
    }
}