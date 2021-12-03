//Backtracking with Map


class Solution {
public:
    vector<vector<int>> ans;
    map<int,int> mp;
    void backtrack(vector<int> arr,vector<int>& curr){
        if(curr.size()==arr.size()){
            ans.push_back(curr);
            return;
        }
        for(int i=0;i<arr.size();i++){
            if(!mp[i]){
            curr.push_back(arr[i]);
            mp[i]++; //Marking the index as visited
            backtrack(arr,curr);
            curr.pop_back();
            mp[i]--; //Reverting the index as non-visited again.
            }
        }
    }
    vector<vector<int>> permute(vector<int>& nums) {
        vector<int> curr;
        backtrack(nums,curr);
        return ans;
    }
};
