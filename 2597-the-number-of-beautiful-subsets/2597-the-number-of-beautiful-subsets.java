class Solution {
    private int solve(int index , int[]nums, Map<Integer, Integer> mp , int k)
    {
        
        if(index == nums.length) return 1;
        int curr = nums[index];
        int res = 0;
        if(!mp.containsKey(curr + k) && !mp.containsKey(curr - k))
        {
            mp.put(curr, mp.getOrDefault(curr, 0) + 1);
            res+=solve(index + 1, nums , mp, k);
            mp.put(curr, mp.get(curr) - 1 );
            if(mp.get(curr) == 0) mp.remove(curr);
            
        }
       res+=solve(index + 1, nums , mp, k ); // not taking
        return res;
    } 
    public int beautifulSubsets(int[] nums, int k) {
        Map<Integer, Integer> mp = new HashMap<>();
        return solve(0, nums , mp, k) - 1 ;
        
        
    }
}

