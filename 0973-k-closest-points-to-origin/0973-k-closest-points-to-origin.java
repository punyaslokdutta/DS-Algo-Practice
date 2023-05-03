class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            new MaxComparator()
        );
        int m = points.length;
        int n = points[0].length;
        for(int[] point : points)
        {
            pq.add(point);
            if(pq.size() > k)
            {
                pq.poll();
            }
        }
        
        return pq.toArray(new int[0][]);
    }
    
    private static class MaxComparator implements Comparator<int[]>
    {
        public int compare(int a[], int b[])
        {
            return (b[0]*b[0] + b[1]*b[1]) - (a[0]*a[0] + a[1]*a[1]);
        }
    }
}