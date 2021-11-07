class Solution {
     // dp[i]=min cost to reach ith step;
     //dp array to memoise the answer till ith step
public:
    int minCostClimbingStairs(vector<int>& _cost) {
        
        
        int answer =solve(_cost);
        return answer;
        //int H=cost.size();
       
        //answer=dp[H-1];
        
        
    }
    
    
    int solve(vector<int>& cost)
    {
        int H=cost.size();
        vector<int>dp(H+1); 
        dp[0]=0;
        dp[1]=0;
        int i;
        int j;
        for (i=2;i<=H;i++)
        {
            dp[i]=min(dp[i-1]+cost[i-1], dp[i-2]+cost[i-2]);
        }
        
        return dp[H];
        
        
        
    }
};
