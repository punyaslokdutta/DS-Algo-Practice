class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int end = 0;
        int start =0;
        int n = nums.length;
        long sum = 0l;
        long ans = 0l;
        Set<Integer> st = new HashSet<>();
        while(end<n)
        {
            int val = nums[end];
            sum+=val;
            while(start< end  && (st.contains(val) || end-start+1 > k))
            {
                sum-=nums[start];
                st.remove(nums[start]);
                start++;
            }
            if(end-start + 1 ==k) ans = Math.max(ans, sum);
            st.add(val);
            end++;
        }
        return ans;
        
    }
}