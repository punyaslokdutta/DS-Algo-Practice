class Solution {
    public boolean isSubsequence(String s, String t) {
        if(s.length() > t.length()) return false;
        int sdx = 0;
        int tdx = 0;
        while(sdx < s.length() && tdx < t.length())
        {
            if(s.charAt(sdx) == t.charAt(tdx)) sdx++;
            tdx++;
        }
        return sdx == s.length();
        
        
    }
}