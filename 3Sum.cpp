
// -4, -1, -1, 0, 1, 2,
//i-0-n-1
//left=i+1
//right=n-1
class Solution {
public:
    vector<vector<int>> threeSum(vector<int>& nums) {
        int n=nums.size();
        vector<vector<int>>ans;
        if (nums.empty()) {
		return ans;
	     }

        sort(nums.begin(), nums.end());
        for(int i=0;i<n;i++)
        {   
            if(nums[i]>0)
                break;
            if(i>0 && nums[i]==nums[i-1])
                continue; //For avoid repeated calculation for third pointer
            int sum=nums[i];
            int left=i+1;
            int right= n-1;
            while(left<right)
            {
                if(sum+ nums[left]+ nums[right]<0)
                {
                    left++;
                }
                else if(sum+ nums[left] + nums[right]>0)
                {
                    right--;
                }
                else{
                    
                    ans.push_back({nums[i], nums[left], nums[right]});
                    int lastLeft=nums[left];
                    int lastRight=nums[right];
                    while(left<right && nums[left]==lastLeft)left++;
                    while(left<right && nums[right]==lastRight)right--;
                    
                }
            }
        }
        
        return ans;
        
        
    }
};
