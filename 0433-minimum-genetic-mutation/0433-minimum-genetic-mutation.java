class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        Set<String> st = new HashSet<>(Arrays.asList(bank));
        Queue<String> q = new LinkedList<>();
        if(!st.contains(endGene)) return -1;
        char []gene = new char[] {'A', 'C', 'G', 'T'};
        q.add(startGene);
        Set<String> vis = new HashSet<>();
        vis.add(startGene);
        int ans = 0;
        while(!q.isEmpty())
        {
            int sz = q.size(); //for storing next level info
            for(int k=1;k<=sz;k++)
            {
                String curr = q.poll();
                if(curr.equals(endGene)) return ans;
                
                for(int i=0;i<curr.length();i++)
                {
                    char []temp = curr.toCharArray();
                    for(char c: gene)
                    {
                        temp[i] = c;
                        String newStr = new String(temp);
                        if(st.contains(newStr) && !vis.contains(newStr))
                        {
                            q.add(newStr);
                            vis.add(newStr);
                        }
                    }
                }    
            }
            ans++;
        }
        
        return -1;
        
        
    }
}