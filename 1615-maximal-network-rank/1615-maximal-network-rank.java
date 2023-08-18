class Solution {
    private void dfs(int node , Map<Integer, List<Integer>> graph , Map<Integer, Integer> compMap, int numComps)
    {
        compMap.put(node , numComps);
        for(int adj : graph.get(node))
        {
            if(!compMap.containsKey(adj)) dfs(adj, graph , compMap , numComps);
        }
    }
    public int maximalNetworkRank(int n, int[][] roads) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        Map<Integer, Integer> compMap = new HashMap<>(); //Node , Comp
        for(int i=0;i<n;i++) graph.put(i, new ArrayList<>());
        for(int[]road : roads)
        {
            int u = road[0];
            int v = road[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        int numComps = 1;
        for(int i=0;i<n;i++)
        {
            if(!compMap.containsKey(i))
            {
                dfs(i, graph, compMap, numComps);
                numComps++;
            }
        }
        int maxNetwork = 0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n ;j++)
            {
                if(i!=j)
                {
                    int networkRank = 0;
                    if(!graph.get(i).contains(j) || compMap.get(i)!= compMap.get(j) )
                        networkRank = graph.get(i).size() + graph.get(j).size();
                    else
                        networkRank = graph.get(i).size() + graph.get(j).size() - 1;
                    maxNetwork = Math.max(maxNetwork, networkRank);
                }
            }
        }
        
        return maxNetwork;
    }
}

// graph
// nC2 pair -> 50*99 -> check num of roads