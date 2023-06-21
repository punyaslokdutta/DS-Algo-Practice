class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int [] map = new int[100009];
        int n = difficulty.length;
        for(int i=0;i<n;i++)
        {
            map[difficulty[i]] = Math.max(map[difficulty[i]], profit[i]);
        }
        //map of difficulty -> maxProfit for that difficulty level
        int m = map.length;
        for(int i=1;i<m;i++)
        {
            map[i] = Math.max(map[i], map[i-1]);
        }
        
        int sum=0;
        for(int w : worker)
        {
            sum+=map[w];
        }
        return sum;
    }
}