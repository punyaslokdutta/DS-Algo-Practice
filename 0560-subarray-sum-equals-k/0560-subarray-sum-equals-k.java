// [1, 2, 3]
// 1, 3, 6
//     k = 3
//     -> {1,2} , {3}

// [a,0, b, c, d, e, ]

class Solution {
    public int subarraySum(int[] nums, int k) {
        //List<Integer> nums = new ArrayList<>();
        //List<Integer> nums = new LinkedList<>();
        Map<Integer, Integer> mp = new HashMap<>();
        mp.put(0,1);
        int ps =0;
        int n  = nums.length;
        int ans =0;
        for(int i=0;i<n;i++)
        {
            ps+=nums[i]; //nums.get(i)
            if(mp.containsKey(ps -k))
            {
                ans+=mp.get(ps-k);
            }
            mp.put(ps, mp.getOrDefault(ps, 0)+1);
            
        }
        return ans;
        
    }
}