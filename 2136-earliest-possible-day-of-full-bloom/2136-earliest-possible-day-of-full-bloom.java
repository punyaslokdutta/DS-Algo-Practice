class Solution {
    public int earliestFullBloom(int[] plantTime, int[] growTime) {
        int n = plantTime.length;
        int [][]arr = new int[n][2];
        for(int i=0;i<n;i++)
        {
            arr[i][0] = growTime[i];
            arr[i][1] = plantTime[i];
        }
        Arrays.sort(arr, (a, b) -> (b[0] - a[0]));
        int curr = 0;
        int t =0 ;
        for(int i=0;i<n;i++){
            t = Math.max(t, curr + arr[i][0] + arr[i][1]);
            curr= curr + arr[i][1];
        }
        
        return t;
        
    }
}


// p[1, 4, 3]
// g[2, 3, 1]
// t = max(t, 3+4)
// curr = 4
    
// t = max(7, 4 + 2 + 1)
// curr = 4 + 1 = 5 
    
// t = max(7, 5 + 1 + 3)
// curr = 5 + 3
// ans = 9
// done 
    




