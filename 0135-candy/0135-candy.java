class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int []dp = new int[n];
        Arrays.fill(dp , 1);
        for(int i=1;i<n;i++)
        {
           if(ratings[i-1] < ratings[i]){
               dp[i] = dp[i-1] + 1;
           }
        }
        for(int i=n-2;i>=0;i--)
        {
            if(ratings[i+1]  < ratings[i] )
            {
                dp[i] = Math.max(dp[i], dp[i+1] + 1);
            }
        }
        int sum =0;
        for(int x: dp) sum+=x;
        return sum;
        
    }
}




// [1,2,87,87,87,2,1]
// 1, 1, 2, 2, 87, 87, 87
// 1  1  2  2  3   3   3
//sorting wont work , cause of adjacency


