class Solution {
    public long taskSchedulerII(int[] tasks, int space) {
        Map<Integer , Long> mp = new HashMap<>();
        //(task, lastIndex)
        for(int task : tasks) mp.put(task, 0l);
        long currDay = 0l;
        for(int i=0;i<tasks.length;i++)
        {
            int task = tasks[i];
            if(mp.containsKey(task)) currDay = Math.max(currDay, mp.get(task));
            mp.put(task, currDay + space + 1);
            currDay++;
        }
        
        
        return currDay;
        
        
        
        
    }
}