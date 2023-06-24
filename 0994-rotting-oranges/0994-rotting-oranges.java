class Solution {
    public static class Pair{
        int x;
        int y;
        public Pair(int x , int y)
        {
            this.x = x;
            this.y = y;
        }
    }
    
    private boolean isValid(Pair p, int m , int n )
    {
        int x = p.x;
        int y = p.y;
        if(x<0 || y<0 || x>=m || y>=n) return false;
        return true;
    }
    public int orangesRotting(int[][] grid) {
        Queue<Pair> q = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;
        int rotten=0;
        int total=0;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j] == 1 || grid[i][j] == 2) total++;
                if(grid[i][j] == 2) q.offer(new Pair(i,j));
            }
        }
        if(total == 0) return 0;
        int time=0;
        while(!q.isEmpty() && rotten<total)
        {
            int sz = q.size();
            rotten+=sz;
            if(total == rotten) return time;
            time++;
            for(int i=0;i<sz;i++)
            {
                Pair p = q.poll();
                int x = p.x;
                int y = p.y;
                Pair adjP1 = new Pair(x+1, y);
                if(isValid(adjP1, m, n) && grid[adjP1.x][adjP1.y] == 1)
                {
                    grid[adjP1.x][adjP1.y] = 2;
                    q.offer(adjP1);
                }
                Pair adjP2 = new Pair(x-1, y);
                if(isValid(adjP2, m, n) && grid[adjP2.x][adjP2.y] == 1 )
                {
                    grid[adjP2.x][adjP2.y] = 2;
                    q.offer(adjP2);
                }
                Pair adjP3 = new Pair(x, y-1);
                if(isValid(adjP3, m, n) && grid[adjP3.x][adjP3.y] == 1)
                {
                    grid[adjP3.x][adjP3.y] = 2;
                    q.offer(adjP3);
                }
                Pair adjP4 = new Pair(x, y+1);
                if(isValid(adjP4, m, n) && grid[adjP4.x][adjP4.y] == 1 )
                {
                    grid[adjP4.x][adjP4.y] = 2;
                    q.offer(adjP4);
                }
            }
            
        }
        
        return -1;
        
        
    }
}

