class Solution {
    public int countPairs(List<Integer> nums, int target) {
        Collections.sort(nums);
        int l=0;
        int n = nums.size();
        int r = n-1;
        int ans=0;
        while(l<r)
        {
            if(nums.get(l) + nums.get(r) < target)
            {
                ans+=r-l;
                l++;
            }
            else{
                r--;
            }
        }
        return ans;
        
    }
}