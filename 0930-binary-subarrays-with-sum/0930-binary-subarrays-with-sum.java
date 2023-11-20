class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int len = nums.length;
        int res =0;
        int ps = 0;
        int []cnt = new int[100000];
        cnt[0] = 1;
        for(int i=0;i<len;i++){
            ps+=nums[i];
            if(ps >= goal)
                res+= cnt[ps - goal];
            cnt[ps]++;
            
        }
        return res;
        
    }
}

