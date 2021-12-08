
//SLIDING WINDOW (O(N))
//BINARY SEARCH (O(NLOGN))

#define ll long long 

class Solution {
public:
    int minSubArrayLen(int target, vector<int>& nums) {
        ll start=0, end=0, sum=0;
        ll n=nums.size();
        ll res=n+1;
        while(end<n)
        {
         sum+=nums[end];
         if(sum<target)
             end++;
         else
         {
             while(sum>=target)
             {
                 res=min(res, end-start+1);
                 sum-=nums[start];
                 start++;
             }
             end++;
         }    
        }
        return (res==n+1)?0:res;
        
    }
};
