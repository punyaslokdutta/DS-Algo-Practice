class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        Map<Integer, Integer> mp = new HashMap<>();
        mp.put(0, 1);
        int n = nums.length;
        int ps = 0;
        int ans =0;
        for(int i=0;i<n;i++)
        {
            ps+=nums[i];
            ps= ps%k;
            if(ps<0) ps+=k;
            ans+=mp.getOrDefault(ps, 0);
            mp.put(ps,mp.getOrDefault(ps, 0) + 1);
        }
        return ans;
        
    }
}


//<Integer, Count>