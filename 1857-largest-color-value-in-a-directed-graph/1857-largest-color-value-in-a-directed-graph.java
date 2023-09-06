class Solution {
    public int largestPathValue(String colors, int[][] edges) {
        int n = colors.length();
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int i=0;i<n;i++) graph.put(i, new ArrayList<>());
        int []indegree = new int[n];
        Arrays.fill(indegree, 0);
        for(int []edge : edges)
        {
            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(v);
            indegree[v]++;
        }
        Queue<Integer> q = new LinkedList<>();
        int [][]memo = new int[n][26]; // memo[index][color] -> maxColor ending at index nod     
        int ans = 0;
        for(int i=0;i<n;i++)
        {
            if(indegree[i] == 0) 
            {
                q.offer(i);
                char ch = colors.charAt(i);
                memo[i][ch - 'a']++;
            }
        }
        
        int count = 0;
        while(!q.isEmpty())
        {
            int curr = q.poll();
            count++;
            if(graph.get(curr).size() == 0)
            {
                ans = Math.max(ans, Arrays.stream(memo[curr]).max().getAsInt());
            }
            for(int adj : graph.get(curr))
            {
                for(int i=0;i<26;i++)
                {
                  memo[adj][i] = Math.max(memo[adj][i], memo[curr][i] + (i == colors.charAt(adj)-'a'? 1 : 0));
                }
                
                if(--indegree[adj] == 0)
                {
                    q.offer(adj);
                }
            }
        }
        
        return (count == n) ? ans : -1;
        
    }
}