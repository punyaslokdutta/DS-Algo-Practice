/**
 * Space Optimized Backtracking
 *
 * Total number of permutations can be found by this equation
 * T(N) = N * T(N-1) + O(N)
 * T(N-1) = (N-1) * T(N-2) + O(N)
 * T(N-2) = (N-2) * T(N-3) + O(N)
 * T(N-3) = (N-3) * T(N-4) + O(N)
 * ...
 * T(2) = 2 * T(1) + O(N)
 * T(1) = O(1)
 * Thus total number of permutations
 *      = N * (P(N,0) + P(N,1) + ... + P(N, N-2)) + P(N,N-1)
 *      = N * (e * N! - P(N,N-1) - P(N,N)) + N!
 *      = ((e-2)*N + 1) * N! = (0.718 * N + 1) * N!
 *
 * Also, if there are S(N) solutions, then time taken to generate these solution will be N^2 * S(N).
 * Here number of solutions will be much less than the total number of permutations.
 * Thus we can ignore the time taken for generating and adding the board in the result list.
 *
 * Total Time Complexity = O(N * N!)
 *
 * Space Complexity:
 * -> O(N) for queensPos arr
 * -> O(N) for recursion depth
 * -> O(1) for occupied BitSet
 *
 * Total Space Complexity = O(N)
 *
 * N = Input board size.
 */
class Solution {
    public List<List<String>> solveNQueens(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("Invalid board");
        }

        List<List<String>> result = new ArrayList<>();
        solveNQueensHelper(result, new int[n], new BitSet(5 * n), 0);
        return result;
    }

    private void solveNQueensHelper(List<List<String>> result, int[] queensPos, BitSet occupied, int row) {
        int n = queensPos.length;
        if (row == n) {
            result.add(generateResultBoard(queensPos));
            return;
        }

        for (int col = 0; col < n; col++) {
            // First N bits are for columns
            // Then 2*N bits are for diagonal at 45 degrees
            // Then 2*N bits are for diagonal at 135 degrees
            int diag45 = n + (row + col);
            int diag135 = 3 * n + (n + row - col);
            if (occupied.get(col) || occupied.get(diag45) || occupied.get(diag135)) {
                continue;
            }

            occupied.set(col);
            occupied.set(diag45);
            occupied.set(diag135);
            queensPos[row] = col;

            solveNQueensHelper(result, queensPos, occupied, row + 1);

            occupied.clear(col);
            occupied.clear(diag45);
            occupied.clear(diag135);
        }
    }

    private List<String> generateResultBoard(int[] queensPos) {
        List<String> temp = new ArrayList<>();
        char[] b = new char[queensPos.length];
        Arrays.fill(b, '.');
        for (int q : queensPos) {
            b[q] = 'Q';
            temp.add(new String(b));
            b[q] = '.';
        }
        return temp;
    }
}