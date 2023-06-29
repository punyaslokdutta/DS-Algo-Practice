class Solution {
    private int getModifiedSum(int m , int []arr)
    {
        int n = arr.length;
        int sum=0;
        for(int i=0;i<n;i++)
        {
            if(arr[i]  > m)
            {
                sum+=m;
            }
            else{
                sum+=arr[i];
            }
        }
        
        return sum;
    }
    public int findBestValue(int[] arr, int target) {
        int l = 0;
        int r = Arrays.stream(arr).max().getAsInt();
        int minDiff = Integer.MAX_VALUE;
        int ans = 0;
        while(l<=r)
        {
            int m = l + (r-l)/2;
            int currSum = getModifiedSum(m, arr);
            if( currSum >= target)
            {
                r = m-1;
            }
            else{
                l = m+1;
            }
            int currDiff = Math.abs(target - currSum);
            if(currDiff < minDiff || (minDiff == currDiff  && m < ans))
                                         {
                                            ans = m;
                                            minDiff = currDiff;
                                         }
        }
        return ans;
    }
}


// [4,9,3]

// for a value of m , sum increasing 