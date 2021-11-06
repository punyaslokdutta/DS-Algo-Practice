class Solution {
public:
    int maximalSquare(vector<vector<char>>& matrix) {
        int H=matrix.size();
        int W=matrix[0].size();
        if(H==0)
        {
            return 0;
        }
        int answer=0;
        vector<vector<int>>dp(H, vector<int>(W));
        int i, j;
        for(i=0;i<H;i++)
        {
            for (j=0;j<W;j++)
            {
                if(matrix[i][j]=='1')
                {
                  dp[i][j]=1;
                  if(i>0 && j>0)
                  {
                dp[i][j]+=min({dp[i-1][j], dp[i][j-1], dp[i-1][j-1]});  
                  }
                  
                }
                answer=max(answer, dp[i][j]);
            }
        }
        
        
        
        return answer*answer;
        
        
    }
};
