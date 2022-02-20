

int maxCost(int index, int N ,vector<int> &price, vector<vector<int>> &dp)
{
    if(index==0)
        return N*price[0];
//     if(N<=0)
//         return INT_MIN;
    if(dp[index][N]!=-1)
        return dp[index][N];
    int take = INT_MIN;
    int not_take = 0 + maxCost(index-1, N, price, dp);
    int rodLength= index+1;
    if(rodLength<=N)
    {
    take = price[index] + maxCost(index, N-rodLength, price, dp);
    }
    dp[index][N]= max(take, not_take);
    return dp[index][N];
}
int cutRod(vector<int> &price, int n)
{
	// Write your code here.
    vector<vector<int>>dp(n,vector<int>(n+1, -1));
    return maxCost(n-1, n, price, dp);
}
