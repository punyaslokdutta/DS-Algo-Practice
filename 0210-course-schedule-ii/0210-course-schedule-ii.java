class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int i=0;i<numCourses;i++) graph.put(i, new ArrayList<>());
        int []inDegree = new int [numCourses];
        for(int [] edge : prerequisites)
        {
            int a = edge[0];
            int b = edge[1];
            graph.get(b).add(a);
            inDegree[a]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(inDegree[i] ==0 ) q.offer(i);
        }
        int []ans = new int[numCourses];
        int count = 0;
        while(!q.isEmpty())
        {
            int f = q.poll();
            ans[count++] = f;
            for(int v : graph.get(f))
            {
                if(--inDegree[v] == 0) q.offer(v);
            }
        }
        //System.out.println(count);
        if(count == numCourses) return ans;
        else return new int[]{};
        
    }
}