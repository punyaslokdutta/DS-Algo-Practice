class Solution {
public:
    vector<int> num;
    int tar;
    int sz;
    map<pair<int,int>,int> mp;
    int fun(int l,int sum)
    {
        if(l==sz) return sum==tar;
        if(mp.find({l,sum})!=mp.end()) return mp[{l,sum}];// O(log sz)
        return mp[{l,sum}]=fun(l+1,sum-num[l])+fun(l+1,sum+num[l]);  
    }
    int findTargetSumWays(vector<int>& nums, int target) {
        num=nums;
        tar=target;
        sz=num.size();
        return fun(0,0);
    }
};

// Runtime: 300 ms, faster than 37.58% of C++ online submissions for Target Sum.
// Memory Usage: 62.2 MB, less than 11.55% of C++ online submissions for Target Sum.


//DFS SOLUTION 
// class Solution {
// public:
//   int answer, t;
  
//   void dfs(vector<int>& nums, int id, int sum){
//     if(id == nums.size()){
//       if(sum == t) answer++;
//       return;
//     }
    
//     dfs(nums, id + 1, sum + nums[id]);
//     dfs(nums, id + 1, sum - nums[id]);
//   }
  
//   int findTargetSumWays(vector<int>& nums, int target) {
//     answer = 0, t = target;
//     dfs(nums, 0, 0);
//     return answer;
//   }
// };


// Runtime: 1176 ms, faster than 17.28% of C++ online submissions for Target Sum.
// Memory Usage: 9 MB, less than 92.13% of C++ online submissions for Target Sum.


// You are given an integer array nums and an integer target.

// You want to build an expression out of nums by adding one of the symbols '+' and '-' before each integer in nums and then concatenate all the integers.

// For example, if nums = [2, 1], you can add a '+' before 2 and a '-' before 1 and concatenate them to build the expression "+2-1".
// Return the number of different expressions that you can build, which evaluates to target.

 

// Example 1:

// Input: nums = [1,1,1,1,1], target = 3
// Output: 5
// Explanation: There are 5 ways to assign symbols to make the sum of nums be target 3.
// -1 + 1 + 1 + 1 + 1 = 3
// +1 - 1 + 1 + 1 + 1 = 3
// +1 + 1 - 1 + 1 + 1 = 3
// +1 + 1 + 1 - 1 + 1 = 3
// +1 + 1 + 1 + 1 - 1 = 3
