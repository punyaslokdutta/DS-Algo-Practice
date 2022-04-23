class Solution {
public:
    int _target;
    vector<vector<int>> ans;
    void findComb(vector<int> &candidates, int index, int target, vector<int> &subAns)
    {
        
        int n = candidates.size();
        if(target<0)
            return;
        if(index==n)
        {
            if(target==0)
               ans.push_back(subAns);
            return;
        }
        //take
        subAns.push_back(candidates[index]);
        findComb(candidates, index, target - candidates[index], subAns);
        subAns.pop_back();
        //if duplicates are present 
        //sort
        //check here 
        // if(index+1<n && candidates[index]== candidates[index+1])
        //     index++;
        findComb(candidates, index+1, target, subAns);
        //not_take
    }
    vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
        vector<int>subAns;
        _target=target;
        findComb(candidates, 0, target, subAns);
        
        return ans;
        
    }
};