
// l, r : [, n-1]
//ans : [0, n]
//in BS questions, to avoid edge cases, dry run with 1, 2,3 elems
class Solution {
    public int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;

        while (start <= end) {
            int mid = start + (end-start)/2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] > target) end = mid-1;
            else start = mid+1;
        }

        return start;
    }
}


//start ........(mid -1).(mid).(mid+1)...........end