class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        int r = n-1;
        int l=0;
        while(l<r)
        {
            if(numbers[l] + numbers[r] > target)
            {
                r--;
            }
            else if(numbers[l] + numbers[r] < target)
            {
                l++;
            }
            else{
                return new int[]{l+1 , r+1};
            }
        }
        
        return null;
    }
}