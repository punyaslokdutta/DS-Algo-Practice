class Solution {
public:
    vector<vector<int>> ans;
    void perm(vector<int>nums, int index)
    {
        if(index==nums.size())
        {
            ans.push_back(nums);
            return;
        }
        for(int k=index;k<nums.size();k++)
        {
           if(index!=k && nums[index]==nums[k])
               continue;
            swap(nums[index], nums[k]);
            perm(nums, index+1);
            //swap(nums[index], nums[k]);
           
        }
    }
    vector<vector<int>> permuteUnique(vector<int>& nums) {
        int n = nums.size();
        sort(nums.begin(), nums.end());
        perm(nums, 0);
        return ans;
        
    }
};