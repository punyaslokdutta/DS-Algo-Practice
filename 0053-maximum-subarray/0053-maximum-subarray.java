class Solution {
    public int maxSubArray(int[] nums) {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum  = Math.max(nums[i], nums[i] + sum);
            max = Math.max(sum , max);
        }
        return max;
    }
}


// [5, 4, -1, -17, 8]