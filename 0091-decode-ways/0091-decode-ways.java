class Solution {
    private int numDecodeHelper(String s, Map<String, Integer> map) {
        if(s.length() == 0 ) {
            return 1;
        }
        
        if(map.containsKey(s)) {
            return map.get(s);
        }
        
        char pickOne = s.charAt(0);
        if(pickOne == '0') {
            return 0;
        }
        int ans = numDecodeHelper(s.substring(1), map);
        if(s.length() >= 2) {
            String pickTwo = s.substring(0,2);
            if(Integer.parseInt(pickTwo) <= 26) {
                ans += numDecodeHelper(s.substring(2), map);
            }
        }
        map.put(s, ans);
        return ans;
    }
    public int numDecodings(String s) {
        Map<String, Integer> dp = new HashMap<>();
        return numDecodeHelper(s,dp);
        
    }
}


// 12 
//     -> AB 
//     -> L
// 226 
    
// f(s)  -> dp[string] = number of ways to map
// "1231123"
    
// f(s) = (1, 231123)  (12, 31123) if((int) first two letters < 26 , can be mapped)
    
