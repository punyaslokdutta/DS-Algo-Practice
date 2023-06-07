class Solution {
    Map<Integer, List<Integer>> graph;
    int[]color;
    boolean isBi;
    boolean dfs(int node)
    {
        for(int v: graph.get(node))
        {
            if(color[v] == 0)
            {
                color[v] = -color[node];
                if(!dfs(v)) return false;
            }
            else if(color[v]!=0 && (color[v] == color[node]))
            {
                return false;
            }
        }
        return true;
    }
    public boolean possibleBipartition(int n, int[][] dislikes) {
        graph = new HashMap<>();
        color = new int[n + 1];
        isBi = true;
         for (int i = 1; i <= n; i++) {
        graph.put(i, new ArrayList<>());
    }
        for(int i=0;i<dislikes.length;i++)
        {
            int u = dislikes[i][0];
            int v = dislikes[i][1];
            graph.get(u).add(v);
            graph.get(v).add(u);
            
        }
        
        Arrays.fill(color , 0); //unvisted;
        for(int i=1;i<=n;i++)
        {
            if(color[i] == 0)
            {
                color[i] = 1;
                if(!dfs(i)) return false;
            }
        }
        
        
        return true;
        
        
        
        
        
    }
}