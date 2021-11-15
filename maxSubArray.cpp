class Solution {
public:
    int maxSubArray(vector<int>& nums) {
        int maxSum = 0;
        int sum = 0;
        int highest = INT_MIN;
        for(int i=0;i<nums.size();i++)
        {
            if(nums[i] > highest)
                highest = nums[i];
            sum = sum + nums[i];
            if(sum > maxSum)
            {
                maxSum = sum;
            }
            if(sum < 0)
            {
                sum = 0;
            }
        }
        
        if(maxSum > 0)
            return maxSum;
        
        return highest;
    }
};


// Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
// A subarray is a contiguous part of an array.
