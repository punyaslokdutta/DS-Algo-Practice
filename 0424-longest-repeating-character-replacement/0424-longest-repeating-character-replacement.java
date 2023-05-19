class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> mp = new HashMap<>();
        int i=0;
        int n = s.length();
        int maxChars = Integer.MIN_VALUE;
        int longWindow = 0;
        for(int j=0;j<n;j++)
        {
            mp.put(s.charAt(j), mp.getOrDefault(s.charAt(j), 0) + 1);
            maxChars = Math.max(maxChars, mp.get(s.charAt(j)));
            while(j-i+1 - maxChars > k)
                                {
                                    char rm = s.charAt(i);
                                    mp.put(rm, mp.getOrDefault(rm, 0) -1);
                                    i++;
                                }
            longWindow = Math.max(longWindow, j-i+1);
        }
                                
        return longWindow;
    }
}


//Map -> maxChars n that window
        //Replacement -> j-i+ 1 - maxChars > k, then shift start
        //j - i + 1 - maxChars is the number of replacements that can be done.