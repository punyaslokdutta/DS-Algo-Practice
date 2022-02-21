
// ROD CUTTING PROBLEM 

// A length N rod can be cut at unit steps example , n pieces , 3 pieces each of n/3 , n/3 and n%3.
// Find the maximum profit to sell the rod into pieces (prices[n]={1, 3, 4, 6, 7, 12, 14, 25})

int maxCost(int index, int remainLen ,vector<int> &price, vector<vector<int>> &dp)
{
    if(index==0)
        return remainLen*price[0];
//     if(N<=0)
//         return INT_MIN;
    if(dp[index][remainLen]!=-1)
        return dp[index][remainLen];
    int take = INT_MIN;
    int not_take = 0 + maxCost(index-1, remainLen, price, dp);
    int rodLength= index+1;
    if(rodLength<=remainLen)
    {
    take = price[index] + maxCost(index, remainLen-rodLength, price, dp);
    }
    dp[index][remainLen]= max(take, not_take);
    return dp[index][remainLen];
}
int cutRod(vector<int> &price, int n)
{
	// Write your code here.
    vector<vector<int>>dp(n,vector<int>(n+1, -1));
    return maxCost(n-1, n, price, dp);
}
