
// take three pointers I,J, K
// nums[j]>= 2* nums[i];
// nums[size-1]- nums[k]>= nums[k]- nums[i];
// LEFT, MID, RIGHT



//PREFIX SUM + THREE POINTER
#define MOD 1000000007
class Solution {
public:
    int waysToSplit(vector<int>& nums) {
        int size = nums.size();
        int res=0;
        partial_sum(begin(nums), end(nums), begin(nums));
        for(int i=0, j=0, k=0;i<size-2;++i)
        {
            j = max( i+1 , j);
            while(j < size-1 && nums[j]<2*nums[i])
                ++j;
            k= max(j, k);
            while(k<size-1 && nums[size-1]- nums[k]>=nums[k] - nums[i])
                ++k;
            res=(res+k-j)%MOD;  
        } 
        
        return res;
        
        
    }
};
// class Solution{
//     public:
// int waysToSplit(vector<int>& nums) {
//     int res = 0, sz = nums.size();
//     partial_sum(begin(nums), end(nums), begin(nums));
//     for (int i = 0, j = 0, k = 0; i < sz - 2; ++i) {
//         j = max(i + 1, j);
//         while (j < sz - 1 && nums[j] < nums[i] * 2)
//             ++j;
//         k = max(j, k);
//         while (k < sz - 1 && nums[k] - nums[i] <= nums[sz - 1] - nums[k])
//             ++k;
//         res = (res + k - j) % 1000000007;
//     }
//     return res;
// } 
// };
