

//[1, 1, -1, 2, -1, -1 ]

class Solution {
    public int subarraySum(int[] nums, int k) {
        int ps = 0;
        int ans =0;
        Map<Integer, Integer> mp = new HashMap<>();
        mp.put(0, 1);
        for(int i = 0;i<nums.length;i++)
        {
            ps+= nums[i];
            if(mp.containsKey(ps - k))
                ans += mp.get(ps -k);
            mp.put(ps, mp.getOrDefault(ps, 0) + 1);
        }
        return ans;
    }
}