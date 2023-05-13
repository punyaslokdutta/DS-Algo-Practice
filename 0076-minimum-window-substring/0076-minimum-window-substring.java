class Solution {
    public String minWindow(String s, String t) {
        int []fmap = new int[150];
        for(char c: t.toCharArray())
        {
            fmap[c]++;
        }
        
        int left=0;
        int right=0;
        int minWindowLen = s.length()+1;
        int charsInWindow =0;
        int allReqChars = t.length();
        String ans = "";
        while(right < s.length())
        {
            char curr = s.charAt(right);
            fmap[curr]--;
            if(fmap[curr]>=0) charsInWindow++;
            while(charsInWindow == allReqChars)
            {
                int windowLen = right - left +1;
                if(windowLen < minWindowLen)
                {
                    minWindowLen = windowLen;
                    ans = s.substring(left, right + 1);
                }
                
                fmap[s.charAt(left)]++;
                if(fmap[s.charAt(left)] > 0) charsInWindow--;
                left++;
                
            }
            right++;
        }
        return ans;
        
    }
}