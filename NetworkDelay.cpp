
//WE DONT NEED A PAIR WHEN WE CAN HAVE DISTANCE ARRAY FOR LOOKUP.
//PAIR<INT, INT> {DISTANCE, NODE} IS NEEDED FOR PRIORITY QUEUE SOLUTION 


class Solution {
public:
    int networkDelayTime(vector<vector<int>>& times, int n, int k) {    
        vector<vector<pair<int, int>>> g(n+1);
        vector<int> dist(n+1, INT_MAX);
        for(auto i: times)
            g[i[0]].push_back({i[2], i[1]}); //{dist, node}
        //priority_queue<pair<int,int>,vector<pair<int,int>>,greater<pair<int,int>>> pq;
        if(g[k].size() == 0){                     // If there is no outgoing edge from k, return -1.
            return -1;
        }
        //queue<int> pq;
        queue<pair<int, int>>pq; //{dist, node}
        pq.push({0,k});
        dist[k]=0;
        int count=0;
        while(!pq.empty())
        {
                //int f= pq.front();
                pair<int, int>f= pq.front();
                pq.pop();
                //count++;
                int distFromSrc=f.first;
                int node=f.second;
                //int node=f;
                for(auto adjNode: g[node])
                {
                    if(dist[adjNode.second]>distFromSrc+ adjNode.first)
                    {
                        dist[adjNode.second]=distFromSrc+ adjNode.first; // dist[parent](from source) + adjacent edge
                        pq.push({dist[adjNode.second], adjNode.second});
                    }
                }
            
        }
        
        int ans=0;
        for(int i=1;i<=n;i++)
        {
           ans= max(ans, dist[i]); 
        }
        return ans==INT_MAX? -1: ans;
        
    }
};
