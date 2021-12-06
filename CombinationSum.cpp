
   class Solution {
public:
    void recur(int ind, vector<int>& c, int target, vector<int>& ds, vector<vector<int>>& ans){
        if(ind == c.size()){
            if(target == 0){
                ans.push_back(ds);
                
            }
            return;
        }
        
        if(c[ind] <= target){
            ds.push_back(c[ind]);
            recur(ind, c, target - c[ind], ds, ans);
            ds.pop_back();
        }
        recur(ind + 1, c, target, ds, ans);
    }
    vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
        vector<vector<int>> ans;
        vector<int> ds;
        recur(0, candidates, target, ds, ans);
        return ans;
    }
