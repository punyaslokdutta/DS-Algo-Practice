class Solution {

    //pq -> distance, price , row , column
    public List<List<Integer>> highestRankedKItems(int[][] grid, int[] pricing, int[] start, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((
            (a,b) -> a[0] == b[0] ? a[1] == b[1] ? a[2] == b[2] ? a[3] - b[3] : a[2] - b[2]: a[1] - b[1] : a[0] - b[0]));
        int m = grid.length;
        int n = grid[0].length;
        List<List<Integer>> ans = new ArrayList<>();
        int [] dir = new int[]{0, 1, 0, -1, 0};
        int lp = pricing[0];
        int rp = pricing[1];
        Set<String> st = new HashSet<>();
        int []startPoint = new int[]{0, grid[start[0]][start[1]],start[0],start[1] };
        pq.add(startPoint);
        st.add(start[0] + "," + start[1]);
        while(!pq.isEmpty() && ans.size() < k){
            int []f = pq.poll();
            int r = f[2];
            int c = f[3];
            int currDist = f[0];
            if(lp <= f[1] && f [1] <= rp) ans.add(Arrays.asList(r,c));
            for(int i=0;i<4;i++){
                int nr = r + dir[i];
                int nc = c + dir[i+1];
                if(nr>=m || nc>=n || nr<0 || nc<0) continue;
                if(grid[nr][nc] == 0 || st.contains(nr + "," + nc)) continue;
                pq.add(new int[]{currDist + 1 , grid[nr][nc], nr, nc});
                st.add(nr + "," + nc);
            }   
        }
        return ans;  
    }
}







