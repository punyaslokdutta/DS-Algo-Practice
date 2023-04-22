class Solution {
    public int edgeScore(int[] edges) {
        int n=edges.length;
        long dp[]=new long[n];
        for(int i=0;i<n;i++){
            dp[edges[i]]+=i;
        }
        long max=0;
        int ans=-1;
        for(int i=0;i<n;i++){
            if(dp[i]>max){
                ans=i;
                max=dp[i];
            }
        }
        return ans;
    }
}