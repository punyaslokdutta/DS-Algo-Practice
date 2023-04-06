class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> mp = new HashMap<>();
        mp.put('I', 1);
        mp.put('V', 5);
        mp.put('X', 10);
        mp.put('L', 50);
        mp.put('C', 100);
        mp.put('D', 500);
        mp.put('M', 1000);
        int ans = 0;
        int counter = 0;
        while(counter < s.length() -1)
        {
            if(mp.get(s.charAt(counter)) < mp.get(s.charAt(counter+1)) )
            {
                ans+= mp.get(s.charAt(counter+1)) - mp.get(s.charAt(counter));
                counter+=2;
            }
            else
            {
                ans+= mp.get(s.charAt(counter));
                counter++;
            }
                
        }
        
        if(counter< s.length())
            ans+=mp.get(s.charAt(counter));
        
        return ans;
        
    }
}