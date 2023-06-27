class Solution {
    private boolean canFinish(int k , int []piles , int h)
    {
        int n = piles.length;
        double hours = 0;
        for(int i=0;i<n;i++)
        {
            int temp = piles[i]/k;
            if(piles[i]%k !=0) temp++;
            hours+=temp;
        }
        
        return hours<=h;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int r = Arrays.stream(piles).max().getAsInt();
        int l = 1;
        int ans = 1;
        while(l<=r)
        {
            int m = l + (r-l)/2;
            if(canFinish(m, piles , h))
            {
                ans = m;
                r = m-1;
            }
            else{
                l = m+1;
            }
        }
        
        return ans;
    }
}