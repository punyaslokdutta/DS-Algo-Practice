class Solution {
    List<List<Integer>> ans;
    private void backtrack(int[]digit, int index , int k , int remain, List<Integer> temp)
    {
       if(index == 9)
       {
           if(temp.size() == k && remain == 0){
               ans.add(new ArrayList<>(temp));
           }
           return;
       }
        
        temp.add(digit[index]);
        backtrack(digit , index+1, k , remain - digit[index], temp);
        temp.remove(temp.size() - 1);
        backtrack(digit , index + 1, k, remain , temp);
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        ans = new ArrayList<>();
        int []digit = new int[]{1,2,3,4,5,6,7,8,9};
        backtrack(digit, 0 , k , n, new ArrayList<>());
        return ans;
        
        
    }
}