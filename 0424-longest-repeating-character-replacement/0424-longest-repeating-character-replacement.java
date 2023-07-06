class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> mp = new HashMap<>();
        int majorityCharCount = 0;
        int len = s.length();
        int maxWindow = 0;
        int i = 0;
        int j =0;
        while(j<len)
        {
            char ch = s.charAt(j);
            mp.put(ch, mp.getOrDefault(ch, 0) + 1);
            majorityCharCount = Math.max(majorityCharCount, mp.get(ch));
            if(j-i+1 - majorityCharCount > k)
            {
                char rm = s.charAt(i);
                mp.put(rm , mp.get(rm) -1 );
                i++;
            }
            maxWindow = Math.max(maxWindow, j - i + 1 ); 
            j++;
        }
        return maxWindow;
        
        
    }
}