
/*
    Time Complexity : O(V + E) 
    Space Complexity:O(V^2) 
    
    where V is the number of vertices in the graph and E is the number of edges in the graph.
*/

//Check If Path Exists (CODING NINJAS)

//DFS
bool dfs(vector<vector<int>> &g, int src, int dest, vector<int> &vis)
{
    if(src == dest)
        return true;
    vis[src]= 1;
    for(auto i: g[src])
    {
        bool res;
       if(vis[i]==0)
       {
           res = dfs(g, i, dest, vis); 
       }
       if(res)
       {
          return true;
       }
       // IF ANY OF THE ADJACENT NODES RETURN TRUE, RETURN TRUE AS ANS;
    }
    //WHEN ALL THE PATHS ARE EXHAUSTED, RETURN FALSE, SINCE NO PATH
    return false;
}

#include<queue>
bool checkPathExists(int v, int e, int source, int destination, vector<vector<int>> &edges) 
{
    // Write your code here
    vector<vector<int>> g;
    int vis[v]={0};
    for(auto e: edges){
      g[e[0]].push_back(e[1]); //directed + unweighted
    }
    //return dfs(g, source, destination, vis);
    queue<int> q;
    q.push(source);
    while(!q.empty()){
      int size=q.size();
      while(size--)
      {
        int f=q.front();
        q.pop();
        vis[f]=1;
        for(auto node: g[f])
        {
            if(vis[node]==0)
            {
                q.push(node);
            }
        }   
      }  
    }
    //BFS
    if(vis[destination])
        return true;
    else
        return false;
    
    
}




