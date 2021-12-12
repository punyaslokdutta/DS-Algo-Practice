class Solution {
public:
    vector<int> maxSlidingWindow(vector<int>& nums, int k) {
        multiset<int> set;
        int left=0;
        int right=0;
        vector<int> res;
        for(right=0;right<nums.size();right++)
        {
            set.insert(nums[right]); //O(logN)
            if(set.size()==k)
            {
                res.push_back(*(set.rbegin()));
                set.erase(set.find(nums[left++]));
            }        
        }
        return res;
        
    }
};
