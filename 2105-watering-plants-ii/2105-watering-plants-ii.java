class Solution {
    public int minimumRefill(int[] plants, int capacityA, int capacityB) {
        int n = plants.length;
        int start = 0;
        int end = n-1;
        int remA = capacityA;
        int remB = capacityB;
        int refill = 0;
        while(start < end)
        {
            if(plants[start] > remA)
            {
                refill++;
                remA = capacityA;
            }
            remA-=plants[start];
            start++;
            if(plants[end] > remB)
            {
                refill++;
                remB = capacityB;
            }
            remB-=plants[end];
            end--;
        }
        
        if((n%2 == 1) && (Math.max(remA, remB) < plants[n/2]))
        {
            refill++;
        }

        return refill;
    }
}


// [2,2,5,3,3]


// 5 -> remA = 4 , remB = 6 (no refill)
// 5-> remA = 6 , remB = 5 (no refill)
