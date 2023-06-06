class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int[] hmap = new int[26];
        for (char ch : p.toCharArray()) {
            hmap[ch - 'a']++;
        }
        
        int start = 0;
        int end = 0;
        int count = p.length();
        List<Integer> res = new ArrayList<>();
        
        while (end < s.length()) {
            if (hmap[s.charAt(end) - 'a'] > 0) {
                hmap[s.charAt(end) - 'a']--;
                count--;
                end++;
            } else {
                hmap[s.charAt(start) - 'a']++;
                count++;
                start++;
            }
            
            if (count == 0) {
                res.add(start);
            }
            
            if (end - start == p.length()) {
                hmap[s.charAt(start) - 'a']++;
                count++;
                start++;
            }
        }
        
        return res;
    }
}
