#define WATER '0'
#define LAND '1'
#define VISITED '2'
class Solution {
public:
    // NUMBER OF DISCONNECTED COMPONENTS IN A GRAPH
    //vector<vector<char>> grid;
    
    
    
   bool isValid(int i, int j, int n, int m )
   {
       if(i<0 || j<0 || j>=m || i>=n)
       {
           return false;
       }
       return true;
   }
    
    void dfs(vector<vector<char>> &grid, int i, int j)
    {
        if(!isValid(i,j, grid.size(), grid[0].size() ))
        {
            return;
        }
        if(grid[i][j]==VISITED || grid[i][j]==WATER)
        {
            return;
        }
        grid[i][j]=VISITED;
        dfs(grid, i-1, j);
        dfs(grid, i+1, j);
        dfs(grid, i, j-1);
        dfs(grid, i, j+1);
        
    }
   
    int numIslands(vector<vector<char>>& grid) {
        int i, j;
        int islands=0;
        for(i=0;i<grid.size();i++)
        {
            for(j=0;j<grid[0].size();j++)
            {
                if(grid[i][j]!=VISITED && grid[i][j]!=WATER  )
                {
                    dfs(grid, i, j);
                    islands++;
                }
            }
        }
        
        
        return islands;
           
             
    }
};

