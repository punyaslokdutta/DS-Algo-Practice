class Solution {
public:
    int longestConsecutive(vector<int>& nums) {
        unordered_set<int> mSet(nums.begin(), nums.end()); //O(n)
        int longestStk=0; //counter
        
        for(int num : nums) //iterating through the array
        {
            if(mSet.find(num-1) == mSet.end()) // find takes O(1) hashset
            {
                int curNum=num;
                int curStk=1;
            
            while(mSet.find(curNum+1)!=mSet.end())
            {
                curNum++;
                curStk++;
            }
                longestStk=max(longestStk, curStk);
        }    
        }
        
        return longestStk;
        
    }
};



// class Solution {
// public:
//     int longestConsecutive(vector<int>& nums) {
//         set<int>s;
//         int ans = 0;
//         int n = nums.size();
//         for(int i=0;i<n;i++){
//             s.insert(nums[i]);
//         }
//         for(int i=0;i<n;i++){
//             if(s.find(nums[i] +1) == s.end()){
//                 int currmax = 1;
//                 int currnum = nums[i];
//                 while(s.find(currnum -1) != s.end()){
//                     currmax++;
//                     currnum--;
//                 }
//                 ans = max(ans, currmax);
//             }
//         }
//         return ans;
//     }
// };
