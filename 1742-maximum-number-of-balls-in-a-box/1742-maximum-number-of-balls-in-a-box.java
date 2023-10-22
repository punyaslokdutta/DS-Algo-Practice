class Solution {
    private int digitSum(int n){
        int curr = n;
        int sum = 0;
        int rem = 0;
        while(curr!=0){
            rem = curr%10;
            sum+=rem;
            curr = curr/10;
        }
        return sum;
        
    }
    public int countBalls(int lowlimit, int highlimit) {
        int n = highlimit - lowlimit +1;
        int ans = Integer.MIN_VALUE;
        int []freq = new int[highlimit +1];
        for(int i=lowlimit;i<=highlimit;i++){
            int dSum = digitSum(i);
            freq[dSum]++;
            ans = Math.max(ans, freq[dSum]);
            
        }
        return ans;
        
    }
}