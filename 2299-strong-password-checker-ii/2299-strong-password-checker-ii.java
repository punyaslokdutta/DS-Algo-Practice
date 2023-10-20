class Solution {
    public boolean strongPasswordCheckerII(String password) {
        String scc = "!@#$%^&*()-+";
        Set<Character> st = new HashSet<>();
        if(password.length() < 8) return false; 
        for(char ch : scc.toCharArray())
        {
            st.add(ch);
        }
        boolean lc = false;
        boolean uc = false;
        boolean d = false;
        boolean sc = false;
        char lcc = '\0';
        for(char ch : password.toCharArray())
        {
            if(ch>='A' && ch<='Z') uc = true;
            if(ch>='a' && ch<='z') lc = true;
            if(ch>='0' && ch<='9') d = true;
            if(st.contains(ch)) sc = true;
            
            if(lcc == ch) return false;
            lcc = ch;
        }
        
        if(uc == false || lc == false || d == false || sc == false) return false;
        return true;
    }
}