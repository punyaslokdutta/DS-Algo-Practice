

class Solution {
    public String frequencySort(String s) {
        //map<charcter, count>
        //{count, ch} -> maxHeap 
        HashMap<Character, Integer> mp = new HashMap<>();
        for(char ch : s.toCharArray())
        {
            mp.put(ch, mp.getOrDefault(ch, 0) +1);
        }
        PriorityQueue<Character> pq = new PriorityQueue<>(
            (a, b) -> mp.get(b) - mp.get(a)
        );
        pq.addAll(mp.keySet());
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty())
        {
            Character ch = pq.poll();
            Integer count = mp.get(ch);
            while(count-->0)
            {
               sb.append(ch); 
            }
            
        }
                   
        return sb.toString();
           
    }
    
}