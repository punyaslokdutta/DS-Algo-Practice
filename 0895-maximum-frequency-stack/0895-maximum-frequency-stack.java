
//freqMap 
//List<List<Integer>>
// [1, 2, 3, 4, 6, 7, 8]
//1 -> [2, 4, 5] 
//8 -> [5, 6, 2] return 5 
// List<Map.Entry<Integer, Integer>> [] buckets


class FreqStack {
    Map<Integer, Integer> fMap;
    List<Stack<Integer>> st;
    
    public FreqStack() {
        fMap = new HashMap<>();
        st = new ArrayList<>();
        st.add(new Stack<>());
        
    }
    
    public void push(int val) {
        int freq = fMap.getOrDefault(val, 0);
        freq = freq + 1;
        fMap.put(val,  freq);
        if(freq  == st.size())
        {
            st.add(new Stack<>());
        }
        st.get(freq).push(val);
    }
    
    public int pop() {
        int maxFreq = st.size() -1;
        Stack<Integer> top = st.get(maxFreq);
        int ans = top.pop();
        fMap.put(ans, fMap.get(ans) - 1);
        if(top.isEmpty()) st.remove(maxFreq);
        return ans;
        
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */