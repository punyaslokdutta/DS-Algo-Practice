class Solution {
    public int maximizeGreatness(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int i=0;
        int j=0;
        int ans =0;
        while(j<n){
            if(nums[i]<nums[j]){
                i++;
                ans++;
            }
            j++;
        }
        
        return ans;
    }
}


// -> [1,3,5,2,1,3,1]
// -> [1,1,1,2,3,3,5]