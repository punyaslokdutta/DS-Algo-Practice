class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        int l = 0;
        int r = 10;
        int n = s.length();
        if(n < 10) return new ArrayList<String>();
        Map<String, Integer> mp = new HashMap<>();
        List<String> ans = new ArrayList<>();
        for(int i=0;i+9<n;i++)
        {
            String temp = s.substring(i, i+10);
            if(mp.containsKey(temp) && mp.get(temp) == 1) ans.add(temp);
            mp.put(temp, mp.getOrDefault(temp, 0) + 1);  
        }
        return ans;
        
    }
}