class Solution {
    public boolean canMakeSubsequence(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        int i=0;
        for(int j=0;j<m;j++)
        {
            char c = str2.charAt(j);
            char t = (c == 'a')?(char)'z': (char)(c - 1);
            while(i<n && (str1.charAt(i)!=c && str1.charAt(i)!=t)) i++;
            if(i>=n) return false;
            i++;
        }
        return true;
    }
}


// str1 -> str2 (2^N combination of indices*k)