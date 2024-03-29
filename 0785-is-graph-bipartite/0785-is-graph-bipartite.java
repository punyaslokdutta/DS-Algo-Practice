class Solution {
    static int []color;
    static boolean isBi;
    private void dfs(int node, int[][] graph)
    {
        for(int v: graph[node])
        {
            if(color[v] == 0)
            {
               color[v] = -color[node];
               dfs(v, graph);   
            }
            else if(color[v] == color[node])
            {
                isBi = !(color[node] == color[v]);
                return;
            }
            
        }
    }
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        color = new int[n];
        isBi = true;
        Arrays.fill(color, 0);
        boolean ans = true;
        for(int i=0;i<n;i++)
        {
            if((color[i] == 0))
            {
                color[i] = 1;
                dfs(i, graph); 
            }
        }
        return isBi;
        
    }
}