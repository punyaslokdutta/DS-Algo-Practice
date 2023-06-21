class Solution {
    public int minExtraChar(String s, String[] dictionary) {
        Map<String , Integer> mp = new HashMap<>();
        return solve(s, dictionary, mp);
        
    }
    
    private static int solve(String s , String[] words , Map<String,Integer> mp)
    {
        if(s.length() == 0) return 0;
        if(mp.containsKey(s)) return mp.get(s);
        int minExtraChars = s.length() + 1;
        for(String word : words)
        {
            if(s.startsWith(word))
            {
                minExtraChars = Math.min(minExtraChars , solve(s.substring(word.length()), words, mp));
            }
            minExtraChars = Math.min(minExtraChars, 1 + solve(s.substring(1), words , mp));
        }
        
        mp.put(s, minExtraChars);
        return minExtraChars;
        
        
    }
}
