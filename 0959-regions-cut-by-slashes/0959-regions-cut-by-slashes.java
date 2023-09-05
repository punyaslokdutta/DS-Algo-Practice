class Solution {
    private int dfs(int i, int j , int [][]g) {
    int []dir = new int []{0, 1, 0, -1, 0};
    int n = g.length;
    if (i < 0 || i >= n || j < 0 || j >= n) return 0;
    if (g[i][j] != 0) return 0;
    g[i][j] = 1;
    int ret = 1; // Start with 1 for the current cell
    for (int x = 0; x < 4; x++) {
        int nI = i + dir[x];
        int nJ = j + dir[x+1];
        ret += dfs(nI, nJ, g);
    }
    return ret;
}
    public int regionsBySlashes(String[] grid) {
        int n = grid.length;
        int[][]g = new int[n*3][n*3];
        for(int i=0;i<3*n;i++)
        {
            Arrays.fill(g[i], 0);
        }
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i].charAt(j) == '/')
                {
                    g[i*3][j*3 + 2] = g[i*3 + 1][j*3 + 1] = g[i*3 +2][j*3] = 1;
                }
                else if(grid[i].charAt(j) == '\\')
                {
                    g[i*3][j*3] = g[i*3 + 1][j*3+1] = g[i*3+2][j*3 +2] = 1;
                }
            }
        }
        int comps = 0;
        for(int i=0;i<n*3;i++)
        {
            for(int j=0;j<n*3;j++)
            {
                if(dfs(i, j, g)!=0 )
                {
                    comps++;
                }
            }
        }
        
        return comps;
        
    }
}



// /\\
// \\/