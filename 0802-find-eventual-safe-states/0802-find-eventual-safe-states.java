class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        Map<Integer, List<Integer>> R = new HashMap<>();
        for(int i=0;i<n;i++) R.put(i, new ArrayList<>());
        int []out = new int[n];
        Arrays.fill(out, 0);
        Queue<Integer> q= new LinkedList<>();
        for(int i=0;i<n;i++)
        {
            for(int v : graph[i])
            {
                R.get(v).add(i); // i->v is changed to v->i
                out[i]++;
            }
            if(out[i] == 0) q.offer(i);
        }
        List<Integer> ans = new ArrayList<>();
        while(!q.isEmpty())
        {
            int f = q.poll();
            ans.add(f);
            for(int v: R.get(f))
            {
                if(--out[v] == 0) q.offer(v);
            }
        }
        
        Collections.sort(ans, (a, b)-> a-b);
        return ans;
        
        
        
    }
}