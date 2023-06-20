class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int l = Arrays.stream(weights).max().getAsInt();
        int r = Arrays.stream(weights).sum();
        int ans = 0;
        while(l<=r)
        {
            int mid = l + (r-l)/2;
            if(isPossible(weights , mid , days))
            {
                ans = mid;
                r = mid -1;
            }
            else{
                l = mid+1;
            }
        }
        
        return ans;
    }
    
    private static boolean isPossible(int[] weights, int m , int days)
    {
        int currWeightOfShip = 0;
        int day = 1;
        for(int i : weights)
        {
            currWeightOfShip+=i;
            if(currWeightOfShip > m)
            {
                currWeightOfShip = i;
                day++;
            }
        }
        return day<=days;
    }
}


