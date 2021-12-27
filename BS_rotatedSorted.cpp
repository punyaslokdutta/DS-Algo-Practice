class Solution {
public:
    int BS(vector<int>& nums, int l, int h, int target)
    {
        if(l>h)
            return -1;
        int  mid=l+ (h-l)/2;
        if(nums[mid]==target)
            return mid;
        //left part is sorted 
        if(nums[mid]>=nums[l])
        {
            if(nums[mid]>=target && target>= nums[l])
                return BS(nums, l, mid-1, target);
            return BS(nums, mid+1, h, target);
            
        }
        //right part is sorted
        else{
            
            if(target>= nums[mid] && nums[h]>=target)
                return BS(nums, mid+1, h, target);
            return BS(nums, l, mid-1, target);
        }
    }
    int search(vector<int>& nums, int target) {
        int l=0;
        int h=nums.size()-1;
        return BS(nums, l, h, target);
        
    }
};
