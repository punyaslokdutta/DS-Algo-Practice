class Solution {
    private List<List<Integer>> ans;
    private void dfs(int node , int [][]graph , List<Integer>temp)
    {
        temp.add(node);
        if(node == graph.length - 1)
        {
            ans.add(new ArrayList<>(temp));
            return;
        }
        for(int v : graph[node]) 
        {
            dfs(v, graph, temp);
            temp.remove(temp.size() - 1);
            
        }
        
        
    }
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        //temp.add(0);
        dfs(0, graph, temp);
        return ans;
    }
}


//List<Integer> currTraversalNodes