class Solution {
    public int search(int[] nums, int target) {
        int l = 0 ;
        int r = nums.length - 1;
        int ans = -1;
        while(l<=r)
        {
            int m = l + (r- l)/2;
            if(nums[m] == target){
                ans = m;
                break;
            }
            else if(nums[m]>target){
                r = m-1;
            }
            else{
                l = m+1;
            }
        }
        
        return ans;
        
    }
}