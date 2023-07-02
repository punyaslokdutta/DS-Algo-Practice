class Solution {
    public boolean isCovered(int[][] ranges, int left, int right) {
        int[]dp  = new int[60];
        Arrays.fill(dp, 0);
        for(int []range : ranges)
        {
            for(int i=range[0];i<=range[1];i++) dp[i]++;
        }
        for(int i=left;i<=right;i++)
        {
            if(dp[i] == 0) return false;
        }
        return true; 
    }
}