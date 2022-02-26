

// You are given an m x n binary matrix grid. An island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.)
// You may assume all four edges of the grid are surrounded by water.
// The area of an island is the number of cells with a value 1 in the island.
// Return the maximum area of an island in grid. If there is no island, return 0.


class Solution {
public:
    int dfs(vector<vector<int>> &grid, int i, int j)
    {
        if(i<0 || j<0 || i>=grid.size() || j>=grid[0].size() ||grid[i][j] == 0  || grid[i][j]==2)
            return 0;
        grid[i][j]=2;
        return 1 + dfs(grid, i+1, j) + dfs(grid, i-1, j) + dfs(grid, i, j-1) + dfs(grid, i, j+1);
    }
    int maxAreaOfIsland(vector<vector<int>>& grid) {
        int n=grid.size();
        int m=grid[0].size();
        int maxIsland=0;
        int islandArea=0;
        for(int i =0;i<n;i++)
        {
            for(int j =0;j<m;j++)
            {
                if(grid[i][j]==1)
                {
                    islandArea=dfs(grid, i, j);
                    maxIsland= max(maxIsland, islandArea);
                }
            }
        }
        
        return maxIsland;
    }
};
