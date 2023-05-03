


class Pair{
        String word;
        int freq;
        Pair(String word, int freq){
            this.word=word;
            this.freq=freq;
        }
    };
class Solution {
    
    
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer>map=new HashMap<>();
        for(String w:words){
            map.put(w,map.getOrDefault(w,0)+1);
        }
        PriorityQueue<Pair> maxheap=new PriorityQueue<>(new Comparator<Pair>(){
            public int compare(Pair a, Pair b){
                if(a.freq==b.freq)
                    return a.word.compareTo(b.word);
                else 
                    return b.freq-a.freq;
            }
        });
      

        for(Map.Entry<String, Integer>entry:map.entrySet()){
            maxheap.add(new Pair(entry.getKey(),entry.getValue()));
        }
            List<String> res = new ArrayList<>();
            for(int i=0;i<k;i++){
                Pair rem=maxheap.poll();
                res.add(rem.word);
            }
        return res;
        }
        
    }