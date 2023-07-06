class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k<=1) return 0;
        int pr = 1;
        int r=0;
        int l=0;
        int n = nums.length;
        int count = 0;
        while(r<n )
        {
            pr = pr* nums[r];
            while(pr >= k)
            {
                pr = pr/nums[l];
                l++;
            }
            count+= r-l+1;
            r++;
        }
        
        return count;
        
    }
}




// [10, 1, 2, 4, 32, 21, 20]  k = 60 



// [.....l.......r......]

// state[l] = number of subarrays with product less than k till l
// state[r] = 


