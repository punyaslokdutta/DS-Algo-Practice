
//BACKTRACKING 
//TIME COMLEXITY -> (4^K) ..3^K , SINCE THE PERVIOUS NODE IN THE PATH IS NOT TRAVERSED.
//K<=25;
class Solution {
public:
    int maxGold=0;
    int _m;
    int _n;
    int dfs(vector<vector<int>>& grid, int r, int c)
    {
        if(r<0 || r>= _m || c<0 || c>= _n || grid[r][c]==0)
            return 0;
        int goldHere= grid[r][c];
        grid[r][c]=0; //visited
        int ans = max(max(dfs(grid, r-1,c ),dfs(grid,r,c+1)),max(dfs(grid, r+1,c),dfs(grid, r, c-1 )));
        grid[r][c]= goldHere; //backtrack 
        return ans + goldHere;
    }
    int getMaximumGold(vector<vector<int>>& grid) {
        int m = grid.size();
        int n = grid[0].size();
        _m =m;
        _n= n;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]!=0)
                {
                   maxGold= max(maxGold, dfs(grid, i, j));
                }
            }
        }
        
        return maxGold;
        
    }
};
