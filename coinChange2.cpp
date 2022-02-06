
//[1, 2, 5]
//dp[amount]= number of ways to form that amount
class Solution {
public:
//     vector<vector<int>>dp;
//     vector<int> _coins;
//     int numWays(int amount, int index)
//     {
//         if(index == 0)
//             return 0;
//         if(amount == 0)
//             return dp[amount][index]=1;
//         if(dp[amount][index]!=-1)
//             return dp[amount][index];
//        //if amount> coins[index] 
//        if(amount>=_coins[index-1]){
//            return dp[amount][index]= numWays(amount - _coins[index-1], index)
//                + numWays(amount, index-1);
//          }
//       else
//           return dp[amount][index]= numWays(amount, index-1);
          
//     }
//     int change(int amount, vector<int>& coins) {
//         int n = coins.size();
//         dp.resize(amount+1, vector<int>(n+1, -1));
//         //sort(coins.begin(), coins.end());
//         _coins=coins;
//         numWays(amount,n);
        
//         return dp[amount][n];  
//     }
    int change(int amount, vector<int>& coins) {
        int n = coins.size();
        vector<int>dp(amount);
        dp[0]=1;
        for(int i=0;i<coins.size();i++)
        {
            for(int j=coins[i];j<=amount;j++)
            {
                dp[j]+=dp[j-coins[i]];
            }
        }
        
        return dp[amount];
        
    }
};
