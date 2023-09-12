class Solution {
    public int minDeletions(String s) {
        Map<Character, Integer> mp = new HashMap<>();
        for(char c : s.toCharArray()) mp.put(c, mp.getOrDefault(c, 0 ) + 1);
        Set<Integer> st = new HashSet<>();
        int dels = 0;
        for(int f : mp.values())
        {
            while(f > 0 && st.contains(f))
            {
                f--;
                dels++;
            }
            
            st.add(f);
        }
        return dels;
        
    }
}