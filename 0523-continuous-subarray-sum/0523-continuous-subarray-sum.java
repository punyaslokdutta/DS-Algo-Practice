

//TC -> N
class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> mp = new HashMap<>();
        mp.put(0, -1);
        int accSum=0;
        for(int i=0;i<nums.length;i++)
        {
            accSum+=nums[i];
            int rem = accSum%k;
            if(mp.containsKey(rem))
            {
                int len = i - mp.get(rem);
                if(len>=2)
                    return true;
            }
            else{
            mp.put(rem, i); 
            }
            
        }
        return false;
        
    }
}