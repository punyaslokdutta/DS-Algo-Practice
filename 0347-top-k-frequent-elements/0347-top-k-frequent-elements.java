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
        List<Integer> ans2 = new ArrayList<>();
        while(!pq.isEmpty())
        {
            ans2.add(pq.poll().getKey());
        }
        return ans2.stream().mapToInt(Int -> Int).toArray();
    }
}