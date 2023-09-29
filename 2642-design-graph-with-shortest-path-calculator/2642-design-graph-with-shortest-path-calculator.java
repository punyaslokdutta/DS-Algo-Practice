class Graph {

    class Node{
        int vertex;
        int weight;
        public Node(int vertex, int weight){
            this.vertex = vertex;
            this.weight = weight;
        }
    }

    Map<Integer, List<Node>> graph;
    int V;
    int[] dist;
    PriorityQueue<Node> queue;

    public Graph(int n, int[][] edges) {
        V = n;

        dist = new int[V];
        queue = new PriorityQueue<>((a, b) -> a.weight - b.weight);

        graph = new HashMap<>();
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            int weight = edge[2];

            graph.putIfAbsent(u, new ArrayList<>());
            graph.get(u).add(new Node(v, weight));
        }
    }
    
    public void addEdge(int[] edge) {
        int u = edge[0];
        int v = edge[1];
        int weight = edge[2];

        graph.putIfAbsent(u, new ArrayList<>());
        graph.get(u).add(new Node(v, weight));
    }
    
    public int shortestPath(int node1, int node2) {
        return shortestPathHelper(node1, node2);
    }

    private int shortestPathHelper(int src, int dest){
        Arrays.fill(dist, Integer.MAX_VALUE);
        queue.clear();

        dist[src] = 0;
        queue.add(new Node(src, 0));

        while(!queue.isEmpty()){

            Node currNode = queue.poll();

            for(Node childNode : graph.getOrDefault(currNode.vertex, new ArrayList<>())){
                if(dist[childNode.vertex] > dist[currNode.vertex] + childNode.weight){
                    dist[childNode.vertex] = dist[currNode.vertex] + childNode.weight;
                    queue.add(new Node(childNode.vertex, dist[childNode.vertex]));
                }
            }
        }
        return dist[dest] == Integer.MAX_VALUE ? -1 : dist[dest];
    }

}
