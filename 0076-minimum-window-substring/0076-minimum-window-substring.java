class Solution {
    public String minWindow(String s, String t) {
        int [] mp = new int[150];
        for(char c : t.toCharArray())
        {
            mp[c]++;
        }
        int l = 0;
        int r = 0;
        int n = s.length();
        int charsReq = t.length();
        int charsInWindow = 0;
        String ans = "";
        int minLen = n+1;
        while(r<n)
        {
            char ch = s.charAt(r);
            mp[ch]--;
            if(mp[ch] >=0 ) charsInWindow++;
            while( charsInWindow == charsReq )
            {
                 char leftCh = s.charAt(l);
                 int len = r - l + 1;
                 if(len < minLen)
                 {
                     minLen = len;
                     ans = s.substring(l, r+1);
                 }
                 mp[leftCh]++;
                 if(mp[leftCh] > 0) charsInWindow--;
                 l++;   
            }
            r++;
        }
        
        return ans;
    }
}