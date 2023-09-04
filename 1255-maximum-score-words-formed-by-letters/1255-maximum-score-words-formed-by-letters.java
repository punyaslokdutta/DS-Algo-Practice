class Solution {
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        int [] fMap = new int[26];
        Arrays.fill(fMap, 0);
        for(char ch : letters) fMap[ch - 'a']++;
        return solve(words, fMap , score, 0);
    }
    
    private int solve(String[]words, int []fMap, int[]score, int index)
    {
        if(index == words.length) return 0;
        String word = words[index];
        int scoreForNotTaken = solve(words , fMap , score, index + 1);
        boolean canTakeWord = true;
        int scoreForTaken = 0;
        int temp = 0;
        for(char c: word.toCharArray())
        {
            if(fMap[c-'a'] == 0)
            {
                canTakeWord = false;
            }
            fMap[c-'a']--;
            temp+=score[c-'a'];
            
        }
        
        if(canTakeWord)
        {
            scoreForTaken = temp + solve(words , fMap , score , index + 1);
        } 
        
        for(char c: word.toCharArray()){
            fMap[c-'a']++;
        }
        return Math.max(scoreForNotTaken, scoreForTaken);
    }
}