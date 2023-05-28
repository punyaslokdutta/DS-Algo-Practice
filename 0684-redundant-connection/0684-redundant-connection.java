class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        // construct graph
        Map<Integer,List<Integer>> adj = new HashMap();
        for (int[] edge : edges) {
            int node1 = edge[0];
            int node2 = edge[1];
            // connecting the path
            adj.computeIfAbsent(node1, (key) -> new ArrayList()).add(node2);
            adj.computeIfAbsent(node2, (key) -> new ArrayList()).add(node1);
        }
        
        Queue<Integer> queue = new LinkedList();
        // and add leaf node (that has incoming edge/in-degree of 1) the queue
        for (int node : adj.keySet()) {
            List<Integer> neighbors = adj.get(node);
            // we found a leaf node
            if (neighbors.size() == 1) {
                queue.offer(node);
            }
        }
        
        // do top sort: remove all leafs
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                // get the node from to the queue
                int node = queue.poll();
                // remove the edge the node has
                int neighbor = adj.get(node).remove(0);
                // also remove the edge from neighbor as well
                List<Integer> neighborsAdj = adj.get(neighbor);
                neighborsAdj.remove(Integer.valueOf(node));
                
                // and if the neighbor node in-degree became 1 by edge removal
				// (indication of leaf node), add this neighbor to the queue
                if (neighborsAdj.size() == 1) {
                    queue.offer(neighbor);
                }
                size--;
            }
        }
        
        // at this point, all the node should have 0 edge except the node that is in a cycle
        // so get these nodes, add it to the set
        // by iterate the adj, and see if the edge/neigbor size is more than == 2, and add it
        Set<Integer> cycleNodes = new HashSet();
        for (int node : adj.keySet()) {
            List<Integer> neighbors = adj.get(node);
            if (neighbors.size() > 1) {
                cycleNodes.add(node);
            }
        }
        
        assert cycleNodes.size() >= 3;
        
        // iterate edges from backwards
        for (int i=edges.length-1; i>=0; i--) {
            int[] edge = edges[i];
            int node1 = edge[0];
            int node2 = edge[1];
			// if both node contains in a cycle/set, then this edge is the redundant one
            if (cycleNodes.contains(node1) && cycleNodes.contains(node2)) {
                return edge;
            }
        }
        
        // not going to be reached here
        return new int[]{0,0};
    }
}