#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    bool containsNearbyDuplicate(vector<int>& nums, int k) {
        std::unordered_map<int, int>mp;
        int i;
        for(i=0;i<nums.size();i++)
        {
            
            if (mp.find(nums[i])!= mp.end() && i-(mp[nums[i]])<=k)
            { 
                return true;
            }
            mp[nums[i]]=i;
        }
        
        return false;          
        
    }
};

//leetcode - ContainsDuplicate2
