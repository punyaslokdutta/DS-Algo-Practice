class Solution {
    public int[] kWeakestRows(int[][] matrix, int k) {
        
        
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            } else {
                return a[1] -b[1];
            }
        });

        for (int row = 0; row < matrix.length; row++) {
            int soldierCount = findSoldierCount(matrix[row]);
            minHeap.offer(new int[]{soldierCount, row});
        }

        int[] weakestRows = new int[k];
        for (int i = 0; i < k; i++) {
            weakestRows[i] = minHeap.poll()[1];
        }

        return weakestRows;
    }

    private int findSoldierCount(int[] row) {
        int left = 0, right = row.length - 1;
        int ans = 0;
        while (left <= right) {
            int mid = left + (right - left)/2;
            if (row[mid] == 1) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }
}