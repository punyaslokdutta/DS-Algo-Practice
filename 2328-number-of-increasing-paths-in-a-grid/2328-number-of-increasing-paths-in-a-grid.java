class Solution {
    int [][]dp;
    int mod;
    private int dfs(int i, int j , int prev , int[][]grid)
    {
        if(i<0 || i>= grid.length || j<0 || j>=grid[0].length || prev>= grid[i][j])
            return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int l = dfs(i, j-1, grid[i][j], grid);
        int r = dfs(i, j+1, grid[i][j], grid);
        int d = dfs(i+1, j, grid[i][j], grid);
        int u = dfs(i-1, j ,grid[i][j], grid);
        dp[i][j] = (l+r+d+u+1)%mod;
        return dp[i][j];
    }
    public int countPaths(int[][] grid) {
        mod = (int) (1e9 + 7);
        int paths = 0;
        int n = grid.length;
        int m = grid[0].length;
        dp = new int[n][m];
        for(int i=0;i<n;i++) Arrays.fill(dp[i], -1);
        for(int i=0;i<n ;i++)
        {
            for(int j=0;j<m;j++)
            {
                paths = (paths + dfs(i, j, -1 , grid))%mod;
            }
        }
        return paths;
    }
}