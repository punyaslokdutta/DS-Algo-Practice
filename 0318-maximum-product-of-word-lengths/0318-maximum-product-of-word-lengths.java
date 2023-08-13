class Solution {
    public int maxProduct(String[] words) {
        int n = words.length;
        int[]bitMap = new int[n];
        for(int i=0;i<n;i++)
        {
            String word = words[i];
            for(int j=0;j<word.length();j++)
            {
                bitMap[i] |= 1<<(word.charAt(j) - 'a');
            }
        }
        
        int result = 0;
    for(int i=0; i<bitMap.length; i++) {
        for(int j=i+1; j<bitMap.length; j++) {
            if((bitMap[i] & bitMap[j]) == 0) {
                result = Math.max(words[i].length() * words[j].length(), result);
            }
        }
    }
    return result;
        
    }
}