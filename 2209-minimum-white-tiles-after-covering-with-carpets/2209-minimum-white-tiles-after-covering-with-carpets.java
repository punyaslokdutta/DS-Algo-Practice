class Solution {
    int pref[];

    public int minimumWhiteTiles(String floor, int tot, int len) {
        char a[] = floor.toCharArray();
        this.pref = new int[a.length];
        int c = 0;
        this.dp = new int[a.length + 1][tot + 1];
        for (int d[] : dp) Arrays.fill(d, -1);
        for (int i = 0; i < a.length; i++) {
            if (a[i] == '1') c++;
            pref[i] = c;
        }
        return pref[a.length - 1] - solve(0, a, tot, len);  // total ones - max removed
    }

    int dp[][];

    private int solve(int index, char a[], int tot, int len) {
        if (index >= a.length || tot == 0) {
            return 0;
        }
        if (dp[index][tot] != -1) return dp[index][tot];
        int ones = pref[Math.min(index + len - 1, a.length - 1)] - (index == 0 ? 0 : pref[index - 1]);
        int take = ones + solve(index + len, a, tot - 1, len);  // either take it and add one's count in that subsegment
        int dont = solve(index + 1, a, tot, len);  // or dont 
        return dp[index][tot] = Math.max(take, dont);  // return max of both
    }
}