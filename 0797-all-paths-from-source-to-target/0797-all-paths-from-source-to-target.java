class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        Queue<List<Integer>> q= new LinkedList<>();
        q.add(new ArrayList<>(Arrays.asList(0)));
        List<List<Integer>> ans = new ArrayList<>();
        while(!q.isEmpty())
        {
            List<Integer>f = q.poll();
            int lastNode = f.get(f.size() - 1);
            if(lastNode == graph.length - 1)
            {
                ans.add(f);
                continue;
            }
            for(int v : graph[lastNode])
            {
                List<Integer> nP = new ArrayList<>(f);
                nP.add(v);
                q.add(nP);
            }
        }
        
        return ans;
        
    }
}

//no cycles -> no need of visted set to prevent cycle
//undirected -> check visited
//directed -> check visited in curr traversal stack or color[v] == 1