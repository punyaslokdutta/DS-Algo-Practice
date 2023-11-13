class Solution {
    int _m;
    int _n;
    private int countOnes(String s){
        int count = 0;
        for(char c: s.toCharArray()) if(c == '1') count++;
        return count;
    }
    private int maxSub(int index, int z, int o , String[]strs, int [][][] dp ){
        if(z > _m || o > _n ) return -1;
        if(index >= strs.length) return 0;
        if(dp[index][z][o]!=-1) return dp[index][z][o];
        int numOnes = countOnes(strs[index]);
        int numZeroes = strs[index].length() - numOnes;
        dp[index][z][o] = 
            Math.max(1 + maxSub(index+1, z  + numZeroes, o + numOnes, strs, dp ),
                     maxSub(index + 1, z, o, strs, dp)
                    );
        return dp[index][z][o];
    }
    public int findMaxForm(String[] strs, int m, int n) {
        _m = m;
        _n = n;
        int len = strs.length;
        int [][][]dp = new int[len+1][m+1][n+1];
        for(int [][] arr : dp) for(int []row: arr) Arrays.fill(row, -1);
        return  maxSub(0, 0, 0 , strs, dp);
    }
    
}

