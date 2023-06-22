class Solution {
    public int beautifulSubsets(int[] nums, int k) {
        Map<Integer, Integer> fMap = new HashMap<>();
        return generateSubsets(nums ,0, fMap, k) -1;
    }
    
    public int generateSubsets(int []a ,int index,  Map<Integer, Integer> fMap, int k)
    { 
        if(index == a.length) return 1;
        int res = 0;
        if(!fMap.containsKey(a[index] + k) && !fMap.containsKey(a[index] - k))
        {
            //can add this a[index]
            fMap.put(a[index], fMap.getOrDefault(a[index], 0) + 1);
            res+=generateSubsets(a, index + 1, fMap, k);
            fMap.put(a[index], fMap.get(a[index]) -1);
            if(fMap.get(a[index]) == 0) fMap.remove(a[index]);
        }
        res+=generateSubsets(a , index + 1, fMap,  k);
        return res;
    }
}


// [5, 3, 4, 10, 6, 3, 3] k = 3
    
// [5 ]
// [5, 3]
// [5, 3, 4]

// 2^n 
// 10^3 = 2^10 
// 10^6

// 2^20 

// 2^n * nC2
