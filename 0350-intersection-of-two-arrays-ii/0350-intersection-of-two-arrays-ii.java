class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> mp = new HashMap<>();
        List<Integer> l = new ArrayList<>();
        for(int n : nums1)
        {
            mp.put(n, mp.getOrDefault(n, 0)+1);
        }
        
        for(int n : nums2)
        {
            if(mp.getOrDefault(n, 0) > 0)
            {
                l.add(n);
                mp.put(n, mp.get(n) -1);
            }
        }
        
        return l.stream().mapToInt(Integer -> Integer).toArray();
        
        
    }
}