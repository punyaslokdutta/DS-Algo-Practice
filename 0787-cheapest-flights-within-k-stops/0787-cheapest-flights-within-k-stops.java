
class Solution
{
	public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k)
	{
		List<List<int[]>> adj = new ArrayList<>();
        for(int i =0;i<n;i++)
            adj.add(new ArrayList<>());
		for(int [] flight : flights)
		{
			adj.get(flight[0]).add(new int[]{flight[1], flight[2]});
		}
		Queue<int []> q = new LinkedList<>();
		int []minCost = new int[n];
		Arrays.fill(minCost, Integer.MAX_VALUE);
		q.offer(new int[]{src, 0});
		int steps =0;
		while(!q.isEmpty() && steps<=k)
		{
			int sz = q.size();
			while(sz-- > 0)
			{
				int [] curr = q.poll();
				int currNode = curr[0];
				int currDist = curr[1];
				for(int[] neighbour : adj.get(currNode))
				{
					int price = neighbour[1];
					int neighbourNode = neighbour[0];
					if(price + curr[1] >= minCost[neighbourNode]) continue;
					minCost[neighbourNode] = price + curr[1];
					q.offer(new int []{neighbourNode, price + curr[1]});
				}
			}
			steps++;
		}

		return (minCost[dst] == Integer.MAX_VALUE) ? -1 : minCost[dst];

	}
}
