class Solution {
    private boolean solve(int []stones , Map<Integer, Integer> mp, int currPos , int lastJumpLen , int [][]dp )
    {
        int n = stones.length;
        if(currPos == stones[n-1]) return true;
        if(currPos > stones[n-1]) return false;
        if(lastJumpLen < 1 ) return false; 
        if(dp[mp.get(currPos)][lastJumpLen]!=-1) return dp[mp.get(currPos)][lastJumpLen] == 1;
        boolean path1 = false;
        boolean path2 = false;
        boolean path3 = false;
        
        if(mp.containsKey(currPos + lastJumpLen - 1))
        {
            path1 = solve(stones , mp, currPos + lastJumpLen -1, lastJumpLen -1, dp);
        }
        if(mp.containsKey(currPos + lastJumpLen))
        {
            path2 = solve(stones , mp, currPos + lastJumpLen, lastJumpLen, dp);
        }
        if(mp.containsKey(currPos + lastJumpLen + 1))
        {
            path3 = solve(stones , mp, currPos + lastJumpLen + 1, lastJumpLen + 1 , dp);
        }
        
        int  ans = (path1 || path2 || path3)? 1: 0;
        dp[mp.get(currPos)][lastJumpLen] = ans;
        return ans == 1 ;
        
        
    }
    public boolean canCross(int[] stones) {
        Map<Integer, Integer> mp = new HashMap<>();
        for(int i=0;i<stones.length;i++) mp.put(stones[i], i);
        int [][]dp = new int[2100][2100];
        for(int i=0;i<2100;i++)
        {
            Arrays.fill(dp[i], -1);
        }
        if(stones[1] - stones[0] > 1) return false;
        return solve(stones , mp, stones[1], 1, dp );
        
    }
}