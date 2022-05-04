//[[1,100,3],[7,8,9]], k = 2
//max(solve(indexOfPile, remainingCoins ))



class Solution {
public:
    
    vector<vector<int>> dp; // dp[index][remaining coins]
    int solve(vector<vector<int>> &piles, int index, int remainCoins )
    {
        if(index >= piles.size()  || remainCoins<=0)
            return 0;
        //without taking from indexth pile
        if(dp[index][remainCoins]!=-1)
            return dp[index][remainCoins];
        int not_take = solve(piles, index+1, remainCoins);
        int ans = not_take;
        //taking from indexth  pile
        int x = piles[index].size();
        int range = min(remainCoins,x);
        int take =INT_MIN;
        int sum =0;
        for(int i=1;i<=range;i++)
        {
            sum+= piles[index][i-1];
            ans = max(ans,sum + solve(piles, index+1, remainCoins-i));
        }
                    
        return dp[index][remainCoins] = ans;
    }
    int maxValueOfCoins(vector<vector<int>>& piles, int k) {
        int n = piles.size();
        dp.resize(n+1, vector<int>(k+1, -1));
        return solve(piles,0 , k);
       
    }
};