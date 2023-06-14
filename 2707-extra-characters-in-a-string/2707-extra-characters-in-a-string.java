class Solution {
    List<String> st;
    Map<String, Integer> mp;
    int helper(String s){
        if(s.length() == 0 )  return 0;
        if(mp.containsKey(s)) return mp.get(s);
        int ans =s.length() + 1;
        int n = s.length();
        for(String word : st)
        {
            if(s.startsWith(word))
            {
                ans = Math.min(ans, helper(s.substring(word.length())));
            }
        }
        ans = Math.min(ans, 1 + helper(s.substring(1,n)));
        
        mp.put(s, ans);
        return ans;
    }
    public int minExtraChar(String s, String[] dictionary) {
        st = new ArrayList<>();
        mp = new HashMap<>();
        for(var d:dictionary) st.add(d);
        return helper(s);
    }
}