class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> mp = new HashMap<>();
        for(int num : nums)
        {
            mp.put(num, mp.getOrDefault(num, 0)+1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> pq 
        = new PriorityQueue<>((a, b)-> a.getValue() - b.getValue());
        int [] ans = new int[k];

        for(Map.Entry<Integer, Integer> x: mp.entrySet())
        {
            pq.add(x);
            if(pq.size() > k)
            {
                pq.poll();
            }
        }
        int count =0;
        while(!pq.isEmpty())
        {
            ans[count++] = pq.poll().getKey();
        }
        return ans; 
    }
}