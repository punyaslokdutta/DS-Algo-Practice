public class Solution {
    public int reductionOperations(int[] nums) {
        Map<Integer, Integer> m = new TreeMap<>();
        for (int i : nums) {
            m.put(i, m.getOrDefault(i, 0) + 1);
        }

        int i = 0;
        int ans = 0;
        for (Map.Entry<Integer, Integer> entry : m.entrySet()) {
            int y = entry.getValue();
            ans += (y * i);
            i++;
        }

        return ans;
    }
}

// [2, 4, 5, 6, 6, 7, 7, 7]-> [2, 2, 2, 2, 2, 4, 4]

//3 + (3+ 2) + ()