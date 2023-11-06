class Solution {
        private int m, n;
    Integer[][] memo;
    public int minFallingPathSum(int[][] nums) {
        m = nums.length; n = nums[0].length;
        memo = new Integer[m][n];
        int res = Integer.MAX_VALUE;

        for(int j = 0; j < n; j++)
            res = Math.min(res, dfs(nums, 0, j));//start at every cell in first row

        return res;
    }

    private int dfs(int[][] nums, int i, int j){
        if(i == m) return 0;
        if(j < 0 || j >= n) return Integer.MAX_VALUE;

        if(memo[i][j] != null) return memo[i][j];

        int left = dfs(nums, i + 1, j - 1);
        int right = dfs(nums, i + 1, j + 1);
        int middle = dfs(nums, i + 1, j);

        memo[i][j] = nums[i][j] + Math.min(left, Math.min(right, middle));//take min of all paths and add current cell value

        return memo[i][j];
    }
}