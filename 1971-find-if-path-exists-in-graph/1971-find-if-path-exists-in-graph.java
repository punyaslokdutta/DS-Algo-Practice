class Solution {
    boolean ans;
    private void dfs(int node ,int destination, Map<Integer, List<Integer>> graph , Set<Integer> vis)
    {
        if(node == destination){
            ans = true;
            return;
        }
        vis.add(node);
        for(int adjNode : graph.get(node))
        {
            if(!vis.contains(adjNode))
            {
                dfs(adjNode, destination, graph, vis);
            }
        } 
    }
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        ans = false;
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int i=0;i<n;i++){
            graph.put(i, new ArrayList<>());
        }
        for(int [] e : edges)
        {
            int u = e[0];
            int v = e[1];
            graph.get(u).add(v);
            graph.get(v).add(u); 
        }
        Set<Integer> vis = new HashSet<>();
        dfs(source, destination, graph, vis);
        return ans;
        
    }
}