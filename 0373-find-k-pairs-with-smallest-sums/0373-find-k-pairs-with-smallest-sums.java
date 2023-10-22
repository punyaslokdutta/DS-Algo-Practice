class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int []> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        int n = nums1.length;
        int m = nums2.length;
        for(int i=0;i<n;i++){
            int sum = nums1[i] + nums2[0];
            pq.offer(new int[]{sum, 0});
        }
        List<List<Integer>> ans = new ArrayList<>();
        while( k>0 && !pq.isEmpty()){
            int [] t = pq.poll();
            int sum = t[0];
            int pos = t[1];
            List<Integer> sub = new ArrayList<>();
            sub.add(sum - nums2[pos]);
            sub.add(nums2[pos]);
            ans.add(sub);
            if(pos+1<m){
                pq.offer(new int[]{sum - nums2[pos] + nums2[pos+1], pos+1});
            }
            k--;
        }
        return ans;
        
        
    }
}