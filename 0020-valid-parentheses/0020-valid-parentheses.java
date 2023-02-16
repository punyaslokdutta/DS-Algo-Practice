class Solution {
    public boolean isValid(String s) {
        Map<Character, Integer> umap = new HashMap<>();
        umap.put('(', -1);
        umap.put(')', 1);
        umap.put('{', -2);
        umap.put('}', 2);
        umap.put('[', -3);
        umap.put(']', 3);
            
        Stack<Character> st = new Stack<>();
        for(int idx = 0;idx<s.length();idx++)
        {
            if(umap.get(s.charAt(idx)) < 0)
                st.push(s.charAt(idx));
            else if(umap.get(s.charAt(idx)) > 0)
            {
                int top=0;
                if(!st.empty()) top = umap.get(st.peek());
                if(st.empty() || (top + umap.get(s.charAt(idx))) != 0) return false;
                st.pop();
            }
        }
        
        return st.empty()? true: false;
        
    }
}