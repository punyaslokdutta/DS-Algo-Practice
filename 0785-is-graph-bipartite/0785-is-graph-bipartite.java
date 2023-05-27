class Solution {
    static int []color;
    static boolean isBipartite;
    private boolean dfs(int node, int colorVal, int[][] graph)
    {
        if(color[node] !=0) return color[node] == colorVal;
        color[node] = colorVal;
        for(int v: graph[node])
        {
            if(!dfs(v, -colorVal, graph)) return false;
        }
        return true;
    }
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        color = new int[n];
        isBipartite = true;
        Arrays.fill(color, 0);
        boolean ans = true;
        for(int i=0;i<n;i++)
        {
            if((color[i] == 0) && !dfs(i, 1, graph))
            {
                return false;
            }
        }
        return true;
        
    }
}