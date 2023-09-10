class Solution {
    private int MOD = (int)1e9 + 7;  // Modulus for calculations

    public int countOrders(int numberOfPairs) {
        long count = 1 ;

        // Iterate over all values of pairs from 1 to n
        for (int currentPairs = 1; currentPairs <= numberOfPairs; currentPairs++) {
            // Calculate the number of valid orders for the current number of pairs
            count = count * (2 * currentPairs - 1) * currentPairs % MOD;
        }

        return (int)count; // Return the result for n pairs
    }
};