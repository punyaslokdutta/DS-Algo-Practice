class Solution {
    int n;
    public int minExtraChar(String s, String[] dictionary) {
        n = s.length();

        int dp[] = new int[s.length()];

        Arrays.fill(dp,-1);

        int kc= minExtraChar2(s, dictionary, 0 , dp);

        return kc;
    }



    public int minExtraChar2(String s, String[] dictionary, int start, int dp[]) {
        // base
        if(s.length() == 0) return 0;
        if(dp[start] != -1) return dp[start];
        int ans = Integer.MAX_VALUE;
        int l = Integer.MAX_VALUE; int r = Integer.MAX_VALUE;
        
        boolean foind = false;
        for(String word : dictionary) {

            
            if(s.startsWith(word)) {
               // add to the matched string
               l = minExtraChar2(s.substring(word.length(), s.length()), dictionary, start+word.length(), dp); 
            }
            else{
             r = minExtraChar2(s.substring(1,s.length()), dictionary, start+1, dp) + 1;
            }
            ans = Math.min(ans, Math.min(l, r));
        
        }
        

       
        dp[start] = ans;

        return ans;

        
    }



}