class Solution {
    public int findChampion(int[][] grid) {
        int n = grid.length;
        int []in = new int[n];
        Arrays.fill(in, 0);
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i == j) continue;
                if(grid[i][j] == 1) {
                    //i->j
                    in[j]++;
                }
                else{
                    in[i]++;
                }
            }
        }
        for(int i=0;i<n;i++) if(in[i] == 0) return i;
        return -1;
        
    }
}