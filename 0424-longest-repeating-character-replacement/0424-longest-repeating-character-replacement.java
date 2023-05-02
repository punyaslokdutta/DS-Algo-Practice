class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> mp = new HashMap<>();
        int domChar = 0;
        int maxRepeat = 0;
        int len = s.length();
        int maxWindow = 0;
        int i =0;
        for(int j = 0; j<len;j++)
        {
            char ch = s.charAt(j);
            mp.put(ch, mp.getOrDefault(ch, 0) + 1);
            maxRepeat = Math.max(maxRepeat, mp.get(ch));
            if(j-i+1 -maxRepeat > k)
            {
                char rm = s.charAt(i);
                mp.put(rm , mp.get(rm) -1 );
                i++;
            }
            maxWindow = Math.max(maxWindow, j - i + 1 );
            
        }
        return maxWindow;
        
        
    }
}