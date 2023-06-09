class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Map<String, List<String>> mp = new HashMap<>();
        return dfs(s, wordDict, mp);
    }
    
    
    List<String> dfs(String target , List<String> words , Map<String, List<String>> mp)
    {
        List<String> res = new ArrayList<>();
        if(mp.containsKey(target))
        {
            return mp.get(target);
        }
        if(target.length() == 0)
        {
            res.add("");
            return res;
        }
        
        for(String word : words){
            if(target.startsWith(word))
            {
                List<String> subSents = dfs(target.substring(word.length()),words, mp);
                for(String subSent :subSents)
                {
                   if(subSent.length() == 0)
                   {
                       res.add(word  + subSent);
                   }
                    else{
                        res.add(word + " " + subSent);
                    }
                }
            }
        }
        
        
        mp.put(target, res);
        return res;
    }
}










// cats and dog , ["cat", "cats", "and", "sand", "dog"]
// //How many sentences can be formed so that each word is in words

//next step -> number of sentences if you can't resuse the words again



