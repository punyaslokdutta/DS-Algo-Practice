class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int curr = 1;
        int ans = 0;
        if(nums.length == 1) return 1;
        for(int i=0;i<nums.length - 1;i++)
        {
            if(nums[i+1]>nums[i]){
                curr++;
            }
            else curr = 1;
            ans = Math.max(curr, ans);
            
        }
        return ans;
        
    }
}

// 1 3 5 4 7 
// 7 3 5 6 4 
// 1 4 3 1 2 3