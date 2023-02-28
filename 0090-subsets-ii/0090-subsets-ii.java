class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        subsetHelper(nums, new ArrayList<Integer>(), 0, res);
        return res;   
    }
    
    private void subsetHelper(int []nums, ArrayList<Integer> curr, int index,
                        List<List<Integer>> res)
    {
        if(index >= nums.length)
        {
            res.add(new ArrayList<>(curr));
            return;
        }
        
        curr.add(nums[index]);
        subsetHelper(nums, curr, index+1, res);
        curr.remove(curr.size() - 1 );
        while(index + 1 < nums.length && nums[index] == nums[index + 1])
            index++;
        
        subsetHelper(nums, curr , index +1 , res);
    }
}
        