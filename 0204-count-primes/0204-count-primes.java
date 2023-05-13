class Solution {
    int countPrimes(int n) {
    boolean[] isPrime = new boolean[n];
    // initialize the array to true
    Arrays.fill(isPrime, true);

    for (int i = 2; i < n; i++) 
        if (isPrime[i]) 
            // multiples of i can't be prime anymore
            for (int j = 2 * i; j < n; j += i) 
                    isPrime[j] = false;
    
    int count = 0;
    for (int i = 2; i < n; i++)
        if (isPrime[i]) count++;
    
    return count;
}
}