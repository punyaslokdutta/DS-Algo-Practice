class Solution{
    public boolean possibleBipartition(int n, int[][] dislikes) {
    Map<Integer, List<Integer>> graph = new HashMap<>();
    int[] color = new int[n + 1];
    boolean isBi = true;

    for (int i = 1; i <= n; i++) {
        graph.put(i, new ArrayList<>());
    }

    for (int[] dislike : dislikes) {
        int u = dislike[0];
        int v = dislike[1];
        graph.get(u).add(v);
        graph.get(v).add(u);
    }

    for (int i = 1; i <= n; i++) {
        if (color[i] == 0) {
            color[i] = 1;
            if (!dfs(i, graph, color)) {
                isBi = false;
                break;
            }
        }
    }

    return isBi;
}

private boolean dfs(int node, Map<Integer, List<Integer>> graph, int[] color) {
    for (int neighbor : graph.get(node)) {
        if (color[neighbor] == 0) {
            color[neighbor] = -color[node];
            if (!dfs(neighbor, graph, color)) {
                return false;
            }
        } else if (color[neighbor] == color[node]) {
            return false;
        }
    }
    return true;
}
};
