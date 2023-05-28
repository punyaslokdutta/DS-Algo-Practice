import java.util.*;

class Solution {
    private Map<Integer, List<Integer>> alreadyConnected;
    private Map<Integer, Boolean> visited;

    public int[] findRedundantConnection(int[][] edges) {
        alreadyConnected = new HashMap<>();
        visited = new HashMap<>();

        for (int[] edge : edges) {
            visited.clear();
            int x = edge[0];
            int y = edge[1];
            if (isAlreadyConnected(x, y)) {
                return edge;
            }
            alreadyConnected.computeIfAbsent(x, k -> new ArrayList<>()).add(y);
            alreadyConnected.computeIfAbsent(y, k -> new ArrayList<>()).add(x);
        }

        return new int[2]; // Dummy return statement (should never reach here)
    }

    private boolean isAlreadyConnected(int x, int y) {
        if (x == y) {
            return true;
        }
        visited.put(x, true);
        List<Integer> xAdjacent = alreadyConnected.getOrDefault(x, new ArrayList<>());
        for (int xAdj : xAdjacent) {
            if (!visited.getOrDefault(xAdj, false)) {
                if (isAlreadyConnected(xAdj, y)) {
                    return true;
                }
            }
        }
        return false;
    }
}
