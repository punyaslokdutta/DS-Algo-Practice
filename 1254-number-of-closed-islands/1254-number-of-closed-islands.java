class Solution {
    
    private boolean dfs(int [][]grid, int [][]vis, int x, int y){
        int n = grid.length;
        int m = grid[0].length;
        if(x<0 || y <0 || x>=n || y>=m){
            return false;
        }
        if(grid[x][y] == 1 || vis[x][y] == 1)
            return true;
        vis[x][y] = 1;
        int []dir = new int[]{0, 1, 0, -1, 0};
        boolean isClosed = true;
        for(int i=0;i<4;i++){
            int nx = x + dir[i];
            int ny = y + dir[i+1];
            isClosed&=dfs(grid, vis, nx, ny);
        }
        return isClosed;
    }
    public int closedIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int [][]vis = new int[n][m];
        int islands = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(vis[i][j]==0 && grid[i][j] == 0  && dfs(grid, vis,i, j)){
                    islands++;
                }
            }
        }
        return islands;
    }
}