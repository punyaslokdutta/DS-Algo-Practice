class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        if (p.length() > s.length()) {
            return ans;
        }

        int[] pFreq = new int[26];
        int[] sFreq = new int[26];
        for (int i = 0; i < p.length(); i++) {
            pFreq[p.charAt(i) - 'a']++;
            sFreq[s.charAt(i) - 'a']++;
        }

        if (Arrays.equals(pFreq, sFreq)) {
            ans.add(0);
        }

        int i = 0, j = p.length();
        while (j < s.length()) {
            sFreq[s.charAt(i++) - 'a']--;
            sFreq[s.charAt(j++) - 'a']++;
            if (Arrays.equals(sFreq, pFreq)) {
                ans.add(i);
            }
        }

        return ans;
    }
}