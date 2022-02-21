
//NODES WHICH ARE OUT OF THE BOARD OR HAVE WATER CONTRIBUTE +1 TO THE PERIMETER
// The island doesn't have "lakes", meaning the water inside isn't connected to the water around the island. One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100. Determine the perimeter of the island.
class Solution {
public:
    int perimeter=0;
    int _rows;
    int _cols;
    int dfs(vector<vector<int>> &grid, int i, int j )
    {
        if( i<0 || j <0 || i>=_rows || j>= _cols || grid[i][j]==0)
        {
          return 1;
        }
        if(grid[i][j]==2)
            return 0;
        //int val=grid[i][j];
        grid[i][j]=2; //visited
        return dfs(grid, i+1, j) + dfs(grid, i, j+1) + dfs(grid, i-1, j) + dfs(grid, i, j-1);
    }
    int islandPerimeter(vector<vector<int>>& grid) {
        
        int rows=grid.size();
        int cols= grid[0].size();
        _rows=rows;
        _cols=cols;
        
        for(int i=0;i<rows;i++)
        {
            for(int j =0;j<cols;j++)
            {
                if(grid[i][j]==1)
                     return dfs(grid, i, j);
            }
        }
        
        return perimeter;
        
    }
};
