class Solution {
    public int[] runningSum(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int preSum = 0;
        for(int n : nums)
        {
            preSum+=n;
            ans.add(preSum);
        }
        
        return ans.stream().mapToInt(i->i).toArray();
        
    }
}