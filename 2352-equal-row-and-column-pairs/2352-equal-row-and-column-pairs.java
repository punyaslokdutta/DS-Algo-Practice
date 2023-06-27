class Solution {
    public int equalPairs(int[][] grid) {
        
        Map<String, Integer> rowMap= new HashMap<>();
        int r = grid.length;
        int c = grid[0].length;
        int ans=0;
        for(int i=0;i<r;i++)
        {
            StringBuilder sb = new StringBuilder();
            for(int j=0;j<c;j++)
            {
                sb.append(grid[i][j]);
                sb.append('#');
            }
            rowMap.put(sb.toString(), rowMap.getOrDefault(sb.toString(), 0) + 1);
        }
        
        for(int j=0;j<c;j++)
        {
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<r;i++)
            {
                sb.append(grid[i][j]);
                sb.append('#');
            }
            
            if(rowMap.containsKey(sb.toString())) 
            {
                ans+= rowMap.get(sb.toString());
            }
        }
        
        return ans;
        
    }
}