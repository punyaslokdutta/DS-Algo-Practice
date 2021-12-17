class Solution {
public:
    
    //SIMILAR TO 0-1 KNAPSACK 
    //ITERATE THROUGH THE INDEXES AND EITHER TAKE IT OR NOT TAKE IT 
    //[0, -2, 3, -3, 4]
    //[{0, -2, 3},{-3, 4}]
    // sum/2=0.5

 //              (0, 0)
 //        (1,0)       (1, 0)
 //    (2,-2)   (2,0)  (2, -2) (2, 0)
 // (3, 1) (3, -2)
     
    
    bool canPartition(vector<int>& nums)
{
    int n = nums.size();
    int sum = accumulate(nums.begin(), nums.end(), 0);
    if(sum & 1) return false;
	   vector<vector<bool>> dp(n + 1, vector<bool>(sum/2 + 1));
    for(int i = 0; i <= n; i++)
        dp[i][0] = true;
    for(int i = 1; i <= n; i++)
    {
        for(int j = 1; j <= sum / 2; j++)
        {
            if(j < nums[i - 1])
                dp[i][j] = dp[i - 1][j];
            else
                dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
        }
    }
    return dp[n][sum/2];
}
};

    
    
 
    
    //SUM IS NEGATIVE WHEN THERE ARE ELEMENTS GREATER THAN WHTA NEEDS TO BE FILL SUM/2
//     bool canPartition(vector<int>& nums) {
        
//         int i;
//         int n= nums.size();
//         int sum=0;
//         for(int b: nums)
//             sum+=b;     
        
//         if(sum & 1)
//             return false;
//         vector<vector<int>> dp(n+1, vector<int>(sum/2+1, -1));
//         //dp[n][sum/2];
        
        
//         for (i=0;i<=n;i++)
//         {
//             dp[i][0]= true;
//         }
//         for(i=1;i<=n;i++)
//         {
//             for(int j=1;j<(sum/2)+1;j++)
//             {
//                 // if(i==0 || j==0)
//                 //     dp[i][j]=false;
                
//                 if(nums[i-1]>j)
//                     dp[i][j]=dp[i-1][j];
//                 else
//                    dp[i][j]= dp[i-1][j] || dp[i-1][j-nums[i]];
//             }
//         }
        
        
//         return dp[n][sum/2];
      
        
//     }
// };





















   //TAKE 2D MAP map<pair<index, sum>, bool> //FOR NEGATIVE NUMBERS
//     vector<vector<int>> mem;
//     bool subSetSum(vector<int>& nums, int n ,int index, int sum)
//     {
//         //BASE CONDITION
//         if(sum==0)
//             return true;
//         if(index>=n || sum<0)  //ONE CONDITION TO REMEMBER IS SUM IS INDEX , SO IT CAN'T BE LESS                                  //THAN ZERO
//             return false;
//         if(mem[index][sum]!=-1)
//             return mem[index][sum];
        
//         return mem[index][sum]=subSetSum(nums, n, index+1, sum-nums[index]) || subSetSum(nums, n, index+1, sum);
//     }
    
