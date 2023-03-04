//preSum a[0:n-1] 
//leftSum a[0:n/2];
//rightSum a[n/2+1:n-1]


//[1,7,3,6,5,6]

class Solution {
    public int pivotIndex(int[] nums) {
        int rightSum = 0;
        int leftSum = 0;
        for(int n : nums)
            rightSum+=n;
        
        for(int i= 0;i<nums.length;i++)
        {
            rightSum-=nums[i];
            if(rightSum == leftSum)
                return i;
                
            leftSum+=nums[i];
        }
        return -1;
    }
}