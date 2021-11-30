class Solution {
public:
    int removeElement(vector<int>& nums, int val) {
        int rIndex =0;
        int i;
        for (i=0;i<nums.size();i++)
        {
            if(nums[i]!=val)
                nums[rIndex++]=nums[i]; // inplace removal of an element O(1) space
        }
        return rIndex;
    }
};

//Dont allocate extra space for another array. You must do this by modifying the input array in-place with O(1) extra memory.

//3, 2, 2, 3

3
// nums: 3, 2, 2, 3 // rIndex:0 i=0; 3
// nums: 2,  2, 2, 3         // rIndex:0 i=1; 2
// nums: 2,2,2,3                   //rIndex=1 i=2; 2
