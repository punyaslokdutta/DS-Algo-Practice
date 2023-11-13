class Solution {
    public int numIdenticalPairs(int[] nums) {
        int len = nums.length;
        int ans = 0;
        for(int i=0;i<len-1;i++){
            for(int j =i+1;j<len;j++){
                if(nums[i] == nums[j]) ans++;
            }
        }
        return ans;
    }
}


// i-> 0->

// [1,2,3,1,1,3]
// (1, 2) -> (1, 3) -> (1, 1)->
// (2, 3) -> (2,1)->
// (3, 1)-> (3, 1) -> (3,3)
