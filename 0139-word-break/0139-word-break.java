class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Map<String, Boolean> mp = new HashMap<>();
        return canConstruct(s, wordDict, mp);
    }
    
    private boolean  canConstruct(String target, List<String> words,
                         Map<String, Boolean> mp)
    {
        if(mp.containsKey(target))
            return mp.get(target);
        
        if(target.isEmpty())
            return true;
        for(String word: words)
        {
            if(target.startsWith(word) &&
               canConstruct(target.substring(word.length()), words, mp))
            {
                mp.put(target, true);
                return true;
            }
        }
        
        mp.put(target, false);
        return false;
    }
}