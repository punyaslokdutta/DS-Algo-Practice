class Solution {
    List<List<Integer>> ans;
    private void dfs(int node , List<Integer> path, int[][] graph)
    {
        path.add(node);
        if(node == graph.length -1 )
        {
            ans.add(new ArrayList<>(path));
        }
        
        for(int v : graph[node])
        {
            dfs(v, path, graph);
            path.remove(path.size() -1); //backtrack
        }
    }
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        ans = new ArrayList<>();
        dfs(0, new ArrayList<>(), graph);
        return ans;
    }
}









