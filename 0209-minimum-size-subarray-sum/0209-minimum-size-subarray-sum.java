class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int minLen = Integer.MAX_VALUE;
        int right = 0;
        int sum =0;
        while(right < nums.length)
        {
            sum+=nums[right];
            while(sum>=target)
            {
                sum-=nums[left];
                minLen = Math.min(minLen, right-left +1 );
                left++;
            }
            right++;
        }
        
        return minLen == Integer.MAX_VALUE ? 0: minLen;
        
    }
}