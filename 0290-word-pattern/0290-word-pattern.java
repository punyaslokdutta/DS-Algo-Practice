class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        if(pattern.length()!= words.length)
            return false;
        Map<Character, String> mp = new HashMap<>();
        for(int i = 0;i<pattern.length();i++)
        {
            if(!mp.containsKey(pattern.charAt(i)))
               {
                   if(mp.containsValue(words[i]))
                       return false;
                   mp.put(pattern.charAt(i), words[i]); // mapped
               }
              else
               {
                   if(!mp.get(pattern.charAt(i)).equals(words[i]))
                       return false;
               }
        }
            
        return true;       
        
    }
}