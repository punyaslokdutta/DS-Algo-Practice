class Solution {
    Set<String> st;
    int dp[];
    int helper(String s,int idx){
        if(idx >= s.length()) return 0;
        if(dp[idx] != -1) return dp[idx];
        StringBuilder sb = new StringBuilder();
        int ans =s.length() + 1;
        for(int i = idx;i < s.length();i++){
            sb.append(s.charAt(i));
            if(st.contains(sb.toString())){
                ans = Math.min(ans,helper(s,i + 1));
            }
        }
        ans = Math.min(ans, 1 + helper(s,idx + 1));
        
        return dp[idx] = ans;
    }
    public int minExtraChar(String s, String[] dictionary) {
        st = new HashSet<>();
        dp = new int[s.length()];
        Arrays.fill(dp,-1);
        for(var d:dictionary) st.add(d);
        return helper(s,0);
    }
}