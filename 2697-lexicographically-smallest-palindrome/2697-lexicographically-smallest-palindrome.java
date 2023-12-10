class Solution {
    public String makeSmallestPalindrome(String s) {
        int n = s.length();
        int l = 0;
        int r = n-1;
        char [] arr = s.toCharArray();
        while(l<r){
           if(arr[l]!= arr[r] && arr[l] < arr[r]){
               arr[r] = arr[l];
           }
            else if(arr[l]!= arr[r] && arr[l] > arr[r]){
                arr[l] = arr[r];
            }
            l++;
            r--;
        }
        return new String(arr);
        
    }
}