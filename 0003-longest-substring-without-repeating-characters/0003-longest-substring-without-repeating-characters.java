class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0)
            return 0;
        int ans = 0;
        int j=0;
        Map<Character, Integer> mp = new HashMap<>();
        for(int i = 0; i<s.length();i++)
        {
            if(mp.containsKey(s.charAt(i)))
            {
                j = Math.max(j, mp.get(s.charAt(i)) + 1);
            }
            mp.put(s.charAt(i), i);
            ans = Math.max (ans, i-j + 1 );
        }
        return ans;
    }
}