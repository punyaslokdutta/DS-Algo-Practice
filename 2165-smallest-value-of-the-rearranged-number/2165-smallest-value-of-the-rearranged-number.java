class Solution {
    public long smallestNumber(long num) {
        if(num == 0) return 0;
        char [] ca = ("" + Math.abs(num)).toCharArray();
        Arrays.sort(ca);
        if(num < 0)
        {
            return -Long.parseLong(new StringBuilder(
            new String(ca)).reverse().toString());
        }
        
        int firstNonZero = 0;
        int idx = 0;
        while(idx < ca.length && ca[idx] == '0') idx++;
        char temp = ca[0];
        ca[0] = ca[idx];
        ca[idx] = temp;
        
        return Long.parseLong(new String(ca)); 
    }
}