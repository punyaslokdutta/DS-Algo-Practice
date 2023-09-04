class Solution {
    private int find(int x, int []parent)
    {
        if(x!=parent[x])
        {
            x = find(parent[x], parent);
        }
        
        return parent[x];
    }
    
    private void union(int x , int y, int[]parent)
    {
        int parX = find(x, parent);
        int parY = find(y, parent);
        if(parX!=parY)
        {
            parent[parX] = parY;
        } 
    }
    
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int parent[] = new int[n+1];
        for(int i=1;i<=n;i++)
        {
            parent[i] = i;
        }
        
        for(int []edge : edges)
        {
            int u = edge[0];
            int v = edge[1];
            
            int parU = find(u, parent);
            int parV = find(v, parent);
            if(parU == parV) return edge;
            union(u, v, parent);
        }
        
        return new int[]{0, 0};
    }
}