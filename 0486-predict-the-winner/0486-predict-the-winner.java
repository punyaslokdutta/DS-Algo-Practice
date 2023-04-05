class Solution {
    
    private int predict(int[]nums, int turn , int start, int end)
    {
        if(start > end )
            return 0;
        if(turn == 1)
        {
            //player one plays optimally 
            return Math.max(nums[start] + predict(nums, 2, start+1, end), 
                           nums[end] + predict(nums, 2, start, end -1));
        }
        else{
            
             return Math.min(predict(nums, 1, start+1, end), 
                           predict(nums, 1, start, end -1));
        }
    }
    public boolean PredictTheWinner(int[] nums) {
        int sum = 0;
        int sumOne = 0;
        int sumTwo = 0;
        for(int elem : nums)
            sum+=elem;
        sumOne = predict(nums, 1, 0, nums.length - 1);
        sumTwo = sum - sumOne;
        return (sumOne>=sumTwo);
        
        
    }
}