public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int index = 0;
        Queue<String> queue = new LinkedList<String>();
        queue.offer(s);
        Set<String> visited = new HashSet<String>();
        while(!queue.isEmpty()){
            String candidate = queue.poll();
            if(wordDict.contains(candidate)) return true;
            for(int i = 0; i < candidate.length(); i++){
                String chop = candidate.substring(0,i);
                String next = candidate.substring(i, candidate.length());
                if(!visited.contains(next) && wordDict.contains(chop)){
                    next = candidate.substring(i, candidate.length());
                    queue.offer(next);
                    visited.add(next);
                }
            }
        }
        return false;
    }
}