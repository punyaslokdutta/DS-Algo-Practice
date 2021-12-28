class Solution {
public:
    bool doesExist(vector<int>& nums,int l, int h, int target)
    {
        if(l>h)
            return false;
        int mid= l+ (h-l)/2;
        if(nums[mid]==target)
            return true;
      
        //CONDITION TO HANDLE WHEN DUPLICATE ELEMENTS ARE PRESENT IN SORTED ROTATED ARRAY
        if(nums[mid]==nums[l] && nums[l]==nums[h])
        {
            l++;
            h--;
            return doesExist(nums, l, h, target);
        }
        //left part is sorted
        if(nums[mid]>=nums[l])
        {
            if(nums[mid]>=target && nums[l]<=target)
                return doesExist(nums, l, mid-1, target);
            return doesExist(nums, mid+1, h, target);
        }
        //right part is sorted  
            if(target>=nums[mid] && nums[h]>=target)
                return doesExist(nums, mid+1, h, target);
            return doesExist(nums, l, mid-1, target);
            
    }
    bool search(vector<int>& nums, int target) {
        int h= nums.size()-1;
        int l=0;
        return doesExist(nums, l, h, target);
        
    }
};


// ITERATIVE  (100% FASTER)
// class Solution {
// public:
   
//     bool search(vector<int>& nums, int target) {
//         int h=nums.size()-1;
//         int l=0;
//         while(l<=h)
//         {
//             int m=l + (h-l)/2;
//             if(nums[m]==target)
//                 return true;
//             if(nums[m]==nums[l] && nums[l]==nums[h])
//             {
//                 l++;
//                 h--;
//                 continue;
//             }
//             //IF LEFT PART IS SORTED
//             if(nums[m]>=nums[l])
//             {
//                 if(nums[m]>=target && target >= nums[l])
//                 {
//                   h=m-1;
//                 }
//                 else{
//                    l=m+1;
//                 }
//             }
//             //RIGHT PART IS SORTED 
//             else
//             {
//                 if(nums[h]>=target && target >=nums[m])
//                 {
//                   l=m+1;
//                 }
//                 else{
//                    h=m-1;
//                 }
//             }
//         }
//         return false;
        
//     }
// };
