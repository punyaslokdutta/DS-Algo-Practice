class Solution {
    public int[] runningSum(int[] nums) {
        int ans[] = new int[nums.length];
        int preSum = 0;
        for(int i=0;i<nums.length;i++)
        {
            preSum+=nums[i];
            ans[i] = preSum;
        }
        
        return ans;
        
    }
}