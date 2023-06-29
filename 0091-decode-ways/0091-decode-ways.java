class Solution {
    private int numWays(String s ,int index,  Map<Integer, Integer> dp)
    {
        if(index >= s.length() ) return 1;
        if(s.charAt(index) == '0') return 0;
        if(dp.containsKey(index))
        {
            return dp.get(index);
        }
        int ans = 0;
        ans = numWays(s, index + 1, dp);
        if(index + 1 < s.length())
        {
            if(s.charAt(index) == '1' || s.charAt(index) == '2' && s.charAt(index+1)<'7')
            {
                ans+= numWays(s, index + 2 , dp);
            }
        }
        dp.put(index, ans);
        return ans;
    }
    public int numDecodings(String s) {
        Map<Integer, Integer> dp = new HashMap<>();
        return numWays(s,0,  dp);
        
    }
}


// 12 
//     -> AB 
//     -> L
// 226 
    
// f(s)  -> dp[string] = number of ways to map
// "1231123"
    
// f(s) = (1, 231123)  (12, 31123) if((int) first two letters < 26 , can be mapped)
    
