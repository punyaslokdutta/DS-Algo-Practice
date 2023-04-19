class Solution {
    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        int n = piles.size();
        int dp[][] = new int[n+1][k+1];
        for(int i=0;i<dp.length;i++)
            Arrays.fill(dp[i], -1);
        int ans = solve(piles, 0, k, dp); 
        return ans;
    }
    
    //solve functions gives the max sum that can be formed till indexth pile and
    //remainCoins
    private int solve(List<List<Integer>> piles, int index , int remainCoins , 
                     int [][] dp)
    {
        if(index>=piles.size() || remainCoins<=0)
            return 0;
        
        if(dp[index][remainCoins] != -1 )
            return dp[index][remainCoins];
        
        int ans = 0;
        int not_take = solve(piles, index+1 , remainCoins , dp);
        ans = not_take;
        int sum = 0;
        int range = Math.min(remainCoins, piles.get(index).size());
        for(int i=1;i<=range;i++)
        {
            sum+=piles.get(index).get(i-1);
            ans = Math.max(ans, sum + solve(piles, index + 1, remainCoins -i, dp));
        }
        
        return dp[index][remainCoins] = ans;
        
    }
}