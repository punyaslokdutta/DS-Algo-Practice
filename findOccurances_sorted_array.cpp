
// Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.
// If target is not found in the array, return [-1, -1].
// You must write an algorithm with O(log n) runtime complexity.
//FIND THE OCCURANCES OF A NUMBER = lastPos(x) - firstPos(x) + 1
//lower_bound , upper_bound


class Solution {
public:
    int findPos(vector<int> & nums, int target, string str)
    {
        int ans=-1;
        int s = 0;
        int e = nums.size()-1;
        while(s<=e)
        {
            int m = s+ (e-s)/2;
            if(nums[m]==target)
            {
                ans=m;
                (str=="FIRST") ? e=m-1:s=m+1; //moving towards right for lastPos
            }
            else if(nums[m]>target)
            {
              e=m-1;
            }
            else{
                s=m+1;
            }
        } 
        return ans;  
    }
    vector<int> searchRange(vector<int>& nums, int target) {
        int ans1 = findPos(nums, target, "FIRST");
        int ans2 = findPos(nums, target, "LAST");
        vector<int>p={ans1, ans2};
        return p;
        
        
    }
};
