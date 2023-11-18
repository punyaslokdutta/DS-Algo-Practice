class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int l = 0;
        int n = nums.length;
        long currSum = 0;
        int ans = 1;
        for(int r=0;r<n;r++){
            currSum+=nums[r];
            while(currSum + k < (long)nums[r]*(r- l+1)){
                currSum -= nums[l];
                l++;
            }
            ans = Math.max(ans, r-l+1);
        }
        
        return ans;
        
    }
}



// max length of sliding windows where you can distribute 1's to all elems
// = max freq of the elems after operations

