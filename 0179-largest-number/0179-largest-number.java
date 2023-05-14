class Solution {
    public String largestNumber(int[] nums) {
        String [] arr = new String[nums.length];
        int idx=0;
        for(int x: nums)
        {
            arr[idx++] = Integer.toString(x);
        }
        
        Arrays.sort(arr, (a, b) -> (b+a).compareTo(a+b));
        if(arr[0].charAt(0)== '0') return "0";
        StringBuilder sb = new StringBuilder();
        for(String s:arr) sb.append(s);
        return sb.toString();
        
    }
}