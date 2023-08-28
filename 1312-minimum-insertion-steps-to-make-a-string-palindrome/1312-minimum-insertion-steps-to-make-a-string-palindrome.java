class Solution {
    private int solve(String s, int l , int r , int[][]dp)
    {
        if(r<=l) return 0;
        if(dp[l][r]!=-1) return dp[l][r];
        int ans = 0;
        if(s.charAt(l) == s.charAt(r))
        {
            return dp[l][r] = solve(s, l+1 , r-1 , dp);
        }
        return dp[l][r] = 1 + Math.min(solve(s, l, r-1, dp),solve(s, l+1, r , dp));
    }
    public int minInsertions(String s) {
        int n = s.length();
        int l=0;
        int r = n-1;
        int [][]dp = new int[n][n];
        for(int i=0;i<n;i++)
        {
            Arrays.fill(dp[i], -1);
        }
        return solve(s, l , r, dp);
        
    }
}