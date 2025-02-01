class Solution {
    Map<Integer, List<Integer>> graph;
    int[]color;
    boolean isBi;
    boolean dfs(int node, int colorVal)
    {
        color[node] = colorVal;
        return graph.get(node).stream().allMatch(v -> color[v] == 0 ? dfs(v, -colorVal) : color[v] != color[node]);
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
                if(!dfs(i, 1)) return false;
            }
        }
        
        return true;
        
        
        
        
        
    }
}