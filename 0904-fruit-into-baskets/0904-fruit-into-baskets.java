class Solution {
    public int totalFruit(int[] fruits) {
        int l = 0;
        int n = fruits.length;
        int r = 0;
        Map<Integer, Integer> fMap = new HashMap<>();
        int maxLen = 0;
        while (r < n) {
            int curr = fruits[r];
            fMap.put(curr, r);
            if (fMap.size() > 2) {
                int minIndex = Collections.min(fMap.values());
                fMap.remove(fruits[minIndex]);
                l = minIndex+1;
            }
            maxLen = Math.max(maxLen, r - l + 1);
            r++;
        }
        return maxLen;
    }
}
