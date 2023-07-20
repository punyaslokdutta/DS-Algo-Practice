class Solution {
    public int minFlips(String target) {
        char prev = '0';
        int ans = 0;
        for(char c : target.toCharArray())
        {
            if(prev != c)
            {
                prev = c;
                ans++;
            }
        }
        
        return ans;
    }
}