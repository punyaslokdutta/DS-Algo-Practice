class Solution {
public:
    vector<vector<int>> merge(vector<vector<int>>& intervals) {
        vector<vector<int>> ans;
        sort(intervals.begin(), intervals.end());
        int n=intervals.size();
        ans.push_back(intervals[0]);
        int j=0;
        for(int i=0;i<n;i++)
        {
            if(ans[j][1]>=intervals[i][0]) //OVERLAPPING 
            {
                ans[j][1]=max(ans[j][1], intervals[i][1]);
            }
            else
            {
                j++;
                ans.push_back(intervals[i]);
            }
        }
        return ans;
        
        
    }
};



//[1, 3], [3, 7] , [9, 12]
//[1, 7], [9, 12]
