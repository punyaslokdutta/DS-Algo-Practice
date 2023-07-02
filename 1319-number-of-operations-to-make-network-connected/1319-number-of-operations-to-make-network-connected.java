class Solution {
    
    private void dfs(int node , Map<Integer, List<Integer>> graph, Set<Integer> vis)
    {
        vis.add(node);
        for(int v : graph.get(node))
        {
            if(!vis.contains(v))
            {
                dfs(v, graph, vis);
            }
        }
    }
    public int makeConnected(int n, int[][] connections) {
        int edges = connections.length;
        if(edges < n - 1) return -1;
        Map<Integer, List<Integer>> graph = new HashMap<>();
        Set<Integer>vis = new HashSet<>(); 
        for(int i=0;i<n;i++) graph.put(i , new ArrayList<>());
        for(int[]con : connections)
        {
            int node1 = con[0];
            int node2 = con[1];
            graph.get(node1).add(node2);
            graph.get(node2).add(node1);
        }
        int numComp = 0;
        for(int i=0;i<n ;i++)
        {
            if(!vis.contains(i))
            {
                dfs(i, graph, vis);
                numComp++;
            }
        }
        
        return numComp - 1;
    }
}