class Solution {
    public boolean findSubarrays(int[] nums) {
        
        Map<Integer,Boolean> map = new HashMap<>();
        for(int i = 1 ; i< nums.length;i++)
        {
            if(map.containsKey(nums[i]+ nums[i-1]))
               return true;
            map.put(nums[i] + nums[i-1], true);
        }
        
        return false;
        
    }
}
