
//SLIDING WINDOW (O(N))


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

//BINARY SEARCH (O(NLOGN))

// class Solution {
// public:
//     int minSubArrayLen(int s, vector<int>& nums) {
//         int n = nums.size(), len = INT_MAX;
//         vector<int> sums(n + 1, 0);
//         for (int i = 1; i <= n; i++) {
//             sums[i] = sums[i - 1] + nums[i - 1];
//         }
//         for (int i = n; i >= 0 && sums[i] >= s; i--) {
//             int j = upper_bound(sums.begin(), sums.end(), sums[i] - s) - sums.begin();
//             len = min(len, i - j + 1);
//         }
//         return len == INT_MAX ? 0 : len;
//     }
// };
