class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
       Map<String, List<String>> mp = new HashMap<>();
        for(String str : strs)
        {
            char [] ch = new char[26];
            for(char c :  str.toCharArray())
            {
                ch[c-'a']++;
            }
            String tmp = String.valueOf(ch);
            if(!mp.containsKey(tmp))
                mp.put(tmp, new ArrayList<>());
            mp.get(tmp).add(str);
        }
        
        return new ArrayList<>(mp.values());
    }
}