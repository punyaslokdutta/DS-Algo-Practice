class Solution {
    private List<List<Integer>> ans;
    private int num;
    private int kk;
    private void solve(List<Integer> curr , int index)
    {
        if(index == num){
            if( curr.size() == kk){
            ans.add(new ArrayList<>(curr));
        }
            return;
        }
        
        
        curr.add(index + 1);
        solve(curr , index + 1);
        curr.remove(curr.size() - 1);
        solve(curr , index + 1);
    }
    public List<List<Integer>> combine(int n, int k) {
        List<Integer> curr = new ArrayList<>();
        // for(int i=1;i<=n;i++) curr.add(i);
        int[] arr = new int[n];
        for(int i=0;i<n;i++) arr[i] = i+1;
        num = n;
        kk = k;
        ans = new ArrayList<>();
        solve(curr, 0);
        return ans;
    }
}