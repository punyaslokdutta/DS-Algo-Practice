class Solution {
    private int square(int x){
        return x*x;
    }
    public int[] countPoints(int[][] points, int[][] queries) {
        int n = queries.length;
        int [] ans = new int[n];
        int index= 0;
        for(int [] circle : queries){
            int num = 0;
            for(int [] point : points){
                if(square(point[0] - circle[0]) + square(point[1] - circle[1])<= square(circle[2])){
                    num++;
                }
            }
            ans[index++] = num;
        }
        
        return ans;
    }
}