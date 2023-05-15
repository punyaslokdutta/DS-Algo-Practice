
//Custom comaprator to rearrange the integers in array
//(b+a).compareTo(a + b) -> descending order
class Solution {
    public String largestNumber(int[] nums) {
        int n = nums.length;
        String []arr = new String[n];
        int idx =0;
        for(int x : nums)
        {
            arr[idx++] = Integer.toString(x);
        }
        Arrays.sort(arr, (a, b ) -> (b+a).compareTo(a+b));
        if(arr[0].charAt(0) == '0') return "0";
        StringBuilder sb = new StringBuilder();
        for(String x: arr) sb.append(x);
        return sb.toString();
        
        
    }
}
    
    //sort 900 digits -> 900log900