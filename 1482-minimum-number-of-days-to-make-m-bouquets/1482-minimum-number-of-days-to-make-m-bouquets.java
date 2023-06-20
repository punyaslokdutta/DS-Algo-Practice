class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        int maxElem = 0;
        int minElem = Integer.MAX_VALUE;
        for(int i=0;i<n;i++)
        {
            maxElem = Math.max(bloomDay[i], maxElem);
        }
        for(int i=0;i<n;i++)
        {
            minElem = Math.min(bloomDay[i], minElem);
        }
        int l = minElem;
        int r = maxElem;
        int mid = 0;
        int ans = 0;
        while(l<=r)
        {
            mid = l + (r-l)/2;
            int numBouquets = numOfBouquet(mid, bloomDay, k);
            if(numBouquets >= m)
            {
                ans = mid;
                r = mid-1;
            }
            else if(numBouquets < m){
                l = mid+1;  
            }
            
        }
        return ans == 0 ? -1 : ans;
        
    }
    
    static int numOfBouquet(int day, int []bloom, int k)
    {
        
       int bouquets = 0, flowersCollected = 0;
        for (int value : bloom) {
            if (value <= day) {
//                If the current flower can be taken with in days then increase the flower flowersCollected.
                flowersCollected++;
            } else {
//                If there is a flower in between that takes more number of days then the given day, then resent the counter.
                flowersCollected = 0;
            }
//            If the flowersCollected is same as the required flower per bookie, then increase the bouquets count;
            if (flowersCollected == k) {
                bouquets++;
                flowersCollected = 0;
            }
        }

        return bouquets;
    }
}



// numOfBouquet ( 4, [1, 2, 8, 1, 2, 3,  4, 5, 7 ] , 3)
// {
//     [x, x, 8, x,x,x, 5, 7] -> O(n)
        
// }












// f(i) -> number of flowers bloomed on/before ith day


// for(bd : bloomDay)
// {
    
// }

// [1, 10, 3, 10, 2] -> 