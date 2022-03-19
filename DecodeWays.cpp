// A message containing letters from A-Z can be encoded into numbers using the following mapping:

// 'A' -> "1"
// 'B' -> "2"
// ...
// 'Z' -> "26"
// To decode an encoded message, all the digits must be grouped then mapped back into letters using the reverse of the mapping above (there may be multiple ways). For example, "11106" can be mapped into:

// "AAJF" with the grouping (1 1 10 6)
// "KJF" with the grouping (11 10 6)




//"01" is not same as "1"
//A char can be decoded alone or can be paired with the next character and decoded
class Solution {
public:
//     int  numWays(int index, string s, vector<int> &dp)
//     {
//         //numWays(index)->num of ways to decode the string from ith index to end
//         int n = s.size();
//         if(dp[index]>-1)
//             return dp[index]; //memoization step
//         if(s[index]=='0')
//             return dp[index]=0;
//         int sumWays=numWays(index+1, s, dp); //decoding the first element of the state
//         if(index+1<n && (s[index]=='1'|| s[index]=='2' && s[index+1]<'7'))
//             sumWays+=numWays(index+2, s, dp);
//         return dp[index]=sumWays;
        
//     }
    int numDecodings(string s) {
        int n = s.size();
        if(s.empty())
            return 0;
        vector<int>dp(n+1, -1);
        dp[n]=1;
        //return numWays(0, s, dp);
        //ITERATIVE
        for(int i=n-1;i>=0;i--)
        {
            if(s[i]=='0')
                dp[i]=0;
            else
            {
            dp[i]=dp[i+1];
            if(i+1<n && (s[i]=='1' || s[i]== '2' && s[i+1]<'7'))
               dp[i]+=dp[i+2];
             }
        }
         return dp[0];
    }
};
