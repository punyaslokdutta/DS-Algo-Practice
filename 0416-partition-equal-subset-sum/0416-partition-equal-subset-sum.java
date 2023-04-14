class Solution {
    Boolean mem[][];
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for(int i = 0;i<n;i++)
            sum+=nums[i];
        if(sum%2 != 0)
            return false;
        mem = new Boolean[n+1][sum+1];
        boolean ans = solve(nums, 0, sum/2);
        return ans;
    
    }
    private boolean solve(int[] nums , int index , int sum)
    {
        if(sum == 0)
            return true;
        if(index >=nums.length || sum<0)
            return false;
        if(mem[index][sum]!=null )
            return mem[index][sum];
        
        return 
            mem[index][sum] = solve(nums, index+1, sum - nums[index]) || solve(nums, index+1, sum);
    }
}