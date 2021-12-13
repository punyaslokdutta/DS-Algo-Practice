class Solution {
public:
    vector<int> findMinHeightTrees(int n, vector<vector<int>>& edges) {
    
        if(n==0)
            return {};
        if(n==1)
            return {0};

        vector<vector<int>> adjList(n);
        vector<int> inDegree(n, 0);
        for(int i=0;i<edges.size();i++)
        {
            int a=edges[i][0];
            int b=edges[i][1];
            adjList[b].push_back(a);
            adjList[a].push_back(b);
            inDegree[a]++;
            inDegree[b]++;
        }
        
        //MAKE THE ADJACENCY LIST AND UPDATE INDEGREES
        queue<int>q;
        vector<int>res;
        
        for(int i=0;i<n;i++)
        {
           if(inDegree[i]==1)
           {
               q.push(i);
           }
        }
        //FIND THE INDEGREE 1 NODES WHICH ARE THE LEAFS
        //ELIMINIATE AND DECREASE THE INDEGREES OF THE PARENTS OF THE OUTER NODES
        //KEEP ELIMINIATING AND FIND THE ANSWER LEVEL 
        //WHICH WILL BE THE LAST LEVEL WHERE 1 OR 2 NODES ARE PRESENT AT THE MIDDLE
        while(!q.empty())
        {
            res.clear(); //AT EACH LEVEL THE CLEAR THE ANS BEFORE GOING TO THE NEXT LEVEL
            int size=q.size(); 
            for(int i=0;i<size;i++)
            {
                
                int front=q.front();
                res.push_back(front);
                q.pop();
                for(auto v: adjList[front])
                {
                    if(--inDegree[v]==1)
                    {
                        q.push(v);
                    }
                }
            }
        }
        
        
       return res; 
       
    }
};

