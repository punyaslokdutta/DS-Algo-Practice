class Solution {
    public int[] minOperations(String boxes) {
        int n = boxes.length();
        int [] left = new int[n];
        int [] right = new int[n];
        int c = boxes.charAt(0) - '0';
        for(int i=1;i<n;i++){
            left[i] = left[i-1] + c;
            c += boxes.charAt(i) - '0';
        }
        
        c = boxes.charAt(n-1) - '0';
        for(int i=n-2;i>=0;i--){
            right[i] = right[i+1] + c;
            c += boxes.charAt(i) - '0';
        }
        
        int [] ans = new int[n];
        for(int i=0;i<n;i++){
            ans[i] = left[i] + right[i];
        }
        return ans;
    }
}