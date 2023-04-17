class Solution {
    public int[] topKFrequent(int[] nums, int k) {
    Map<Integer, Integer> mp = new HashMap<>();
    for(int x: nums)
        mp.put(x, mp.getOrDefault(x, 0)+1);
    PriorityQueue<Map.Entry<Integer, Integer>> pq = 
        new PriorityQueue<>(
    (a, b) -> a.getValue() - b.getValue()
    );
    for(Map.Entry<Integer, Integer> x : mp.entrySet())
    {
        pq.add(x);
        if(pq.size() > k)
            pq.poll();
    }
    
    List<Integer> ans = new ArrayList<>();
    while(!pq.isEmpty())
    {
        Map.Entry<Integer, Integer> top = pq.poll();
        ans.add(top.getKey());
    }
    
    return ans.stream().mapToInt(Integer -> Integer).toArray();
        
    }
}