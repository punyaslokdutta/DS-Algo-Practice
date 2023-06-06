class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> st = new HashSet<>(wordList);
        if(!st.contains(endWord)) return 0;
        
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        Set<String> vis = new HashSet<>();
        vis.add(beginWord);
        int ans =1;
        while(!q.isEmpty())
        {
            int size = q.size();
            for(int i=0;i<size;i++)
            {
                String curr = q.poll();
                vis.add(curr);
                if(curr.equals(endWord)) return ans;
                
                for(int k=0;k<curr.length();k++)
                {
                    char []ch = curr.toCharArray();
                    for(int l='a';l<='z';l++)
                    {
                        ch[k] = (char)l;
                        String ss = new String(ch);
                                if(st.contains(ss) && !vis.contains(ss))
                                {
                                    q.add(ss);
                                }
                    }
                    
                }
            }
            ans++;  
        }
        
        
        
        return 0;
    }
}





 
 
//  1. Create a graph (adj[u].add(v)) if(count = currWord.length() - 1) // then make an edge of 1 step
//  2. run dfs/bfs to find the distance from begiinWord -> endWord
 
 
 
 
//  //Innner class 
//  Node{
//  String str;
//  char diffChar;
//     public Node()
//     {
        
//     }
    
//     public void updatediffChar
//  }
//  Map<String , Integer> dist // currWord -> distance from src node
//  dfs(String s , )
//  {
     
     
//  }

// mp // map for string starting word
// for(word : words)
//      {
//          //calculate the difference
//          mp2 //map for string word;
//              for(char ch : word.toCharArray())
//              {
                 
//              }
//      if(count = currWord.length() - 1)
//          adj.get(currWord).add()
//      }
 
 



// hit -> cog 

// hot, him, his , dot , dog , dim , 

// hit -> hot /him / his

