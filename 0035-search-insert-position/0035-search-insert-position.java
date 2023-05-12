class Solution {
    public int searchInsert(int[] nums, int target) {
        int high = nums.length - 1;
        int low = 0;
        int mid = low + (high - low)/2;
        if(target > nums[high])
            return nums.length;
        while(low<high)
        {
            mid = low + (high - low)/2;
            if(nums[mid] == target)
            {
                return mid;
            }
            else if(nums[mid] > target)
            {
                high = mid;
            }
            else
            {
                low = mid + 1;
            }
        }
        return high;        
    }
}