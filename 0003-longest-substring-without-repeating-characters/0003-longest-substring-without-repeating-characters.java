class Solution {
    public int lengthOfLongestSubstring(String s) {
        int ans = 0;
        int start =0;
        Map<Character, Integer> mp = new HashMap<>();
        for(int end =0;end<s.length(); end++)
        {
            if(mp.containsKey(s.charAt(end)))
            {
                start = Math.max(start, mp.get(s.charAt(end))+ 1);
            }
            mp.put(s.charAt(end), end);
            ans = Math.max(ans, end-start +1);
        }
        
        return ans;
        
    }
    
}