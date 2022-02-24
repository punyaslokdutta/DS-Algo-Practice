
// Given a collection of candidate numbers (candidates) and a target number (target), 
// find all unique combinations in candidates where the candidate numbers sum to target.
// Each number in candidates may only be used once in the combination.
// No duplicates

class Solution {
public:
    vector<vector<int>> ans;
    void combinations(int index, vector<int> &candidates, int target, vector<int>&subAns)
    {
         if(target==0)
        {
            ans.push_back(subAns);
            return;
        }
        if(index==candidates.size() || target<0)
            return;
        //take
        subAns.push_back(candidates[index]);
        combinations(index+1, candidates, target-candidates[index], subAns);
        subAns.pop_back();
        //console(subAns);
        //not_take
        while(index+1<candidates.size() && candidates[index+1]==candidates[index])
            index++;
        combinations(index+1, candidates, target, subAns);  
    }
    vector<vector<int>> combinationSum2(vector<int>& candidates, int target) {
        vector<int> subAns;
        sort(candidates.begin(), candidates.end());
        combinations(0, candidates, target,subAns);
        return ans;
        
    }
};
