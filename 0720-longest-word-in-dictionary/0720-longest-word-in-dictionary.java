class Solution {
    public String longestWord(String[] words) {
        Arrays.sort(words);
        Set<String> st = new HashSet<>();
        String res="";
        for(String word : words)
        {
            if(word.length() == 1 || st.contains(word.substring(0, word.length() -1)))
            {
                res = (word.length() > res.length())? word : res; 
                st.add(word);
            }
            
        }
        return res;
        
    }
}