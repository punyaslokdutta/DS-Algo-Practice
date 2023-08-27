class Solution {
    private int solve(int[] satisfaction, int index, int time , int [][] dp)
    {
        int n = satisfaction.length;
        if(index >= n) return 0 ;
        if(dp[index][time]!=-1) return dp[index][time];
        int take = satisfaction[index]*time + solve(satisfaction , index + 1, time+1, dp);
        int not_take = solve(satisfaction, index+1 , time, dp);
        dp[index][time] = Math.max(take, not_take);
        return dp[index][time];
    }
    public int maxSatisfaction(int[] satisfaction) {
        int [][] dp = new int [509][509]; //index , time
        Arrays.sort(satisfaction);
        for(int i=0;i<dp.length;i++)
        {
            Arrays.fill(dp[i], -1);
        }
        return solve(satisfaction, 0 , 1, dp); 
    }
}