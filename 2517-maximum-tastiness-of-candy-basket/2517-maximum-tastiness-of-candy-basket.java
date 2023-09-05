class Solution {
    private boolean canForm(int m , int[]prices, int k)
    {
        int prev = prices[0];
        int n = prices.length;
        int c = 1;
        for(int i=1;i<n;i++)
        {
            if(prices[i] - prev >=m)
            {
                prev = prices[i];
                c++;
            }
            
            if(c == k) return true;
        }
        
        return c == k;
    }
    public int maximumTastiness(int[] price, int k) {
        Arrays.sort(price);
        int n = price.length;
        int l = 0;
        int r = price[n-1] - price[0];
        int ans = 0;
        while(l<=r)
        {
            int m = l + (r-l)/2;
            if(canForm(m, price, k))
            {
                ans = m;
                l=m+1;
            }
            else{
                r = m-1;
            }
        } 
        return ans;
    }
}

// nCk  n! > 2^n
// [13,5,1,8,21,2], k = 3
    
    
// 1 2 5 8 13 21 
