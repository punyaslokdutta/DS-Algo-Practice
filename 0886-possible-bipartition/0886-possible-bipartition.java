class Solution {
    Map<Integer, List<Integer>> graph;
    int[]color;
    boolean isBi;
    void dfs(int node)
    {
        if(!graph.containsKey(node))
            return;
        if(graph.get(node).size() == 0)
            return;
        for(int v: graph.get(node))
        {
            if(color[v] == 0)
            {
                color[v] = -color[node];
                dfs(v);
            }
            else if(color[v]!=0 && (color[v] == color[node]))
            {
                isBi = false;
                return;
            }
        }
    }
    public boolean possibleBipartition(int n, int[][] dislikes) {
        graph = new HashMap<>();
        color = new int[n + 1];
        isBi = true;
        for(int i=0;i<dislikes.length;i++)
        {
            int u = dislikes[i][0];
            int v = dislikes[i][1];
            graph.putIfAbsent(u, new ArrayList<>());
            graph.putIfAbsent(v, new ArrayList<>());
            graph.get(u).add(v);
            graph.get(v).add(u);
            
        }
        
        Arrays.fill(color , 0); //unvisted;
        for(int i=1;i<=n;i++)
        {
            if(color[i] == 0)
            {
                color[i] = 1;
                dfs(i);
            }
        }
        
        
        return isBi;
        
        
        
        
        
    }
}