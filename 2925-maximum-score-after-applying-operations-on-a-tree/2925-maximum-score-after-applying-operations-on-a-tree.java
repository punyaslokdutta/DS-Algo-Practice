class Solution {
    public long maximumScoreAfterOperations(int[][] edges, int[] values) {
        
        int n = values.length;
        List<Integer>[] graph = new ArrayList[n];
        int[][] dp = new int[n][2];

        for (int i=0; i<n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int i=0; i<n-1; i++) {
            int from = edges[i][0];
            int to = edges[i][1];
            graph[from].add(to);
            graph[to].add(from);
        }
        
        long[] res = getSubTreeSum(0, -1, graph, values);

        return Math.max(res[0], res[1]);
    }
    
    private long[] getSubTreeSum(int i, int p, List<Integer>[] graph, int[] values) {
        if (i!=0 && graph[i].size()==1) {
            return new long[]{0, 0};
        }

        long[] res = new long[2];
        // remove root
        res[0] = 0;
        // not remove root
        res[1] += values[i];

        for (Integer child: graph[i]) {
            if ((int) child == p) {
                continue;
            }
            long[] childSum = getSubTreeSum(child, i, graph, values);
            res[0] += (childSum[0]+values[child]);
            res[1] += Math.max(childSum[0], childSum[1]);
        }

        return res;
    }
}