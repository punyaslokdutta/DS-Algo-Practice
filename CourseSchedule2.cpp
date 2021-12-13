class Solution {
public:
    vector<int> findOrder(int numCourses, vector<vector<int>>& prerequisites) {
        //adjList to store the graph from prerequisites
        //inDegrees[nodes]==0, the push into queue
        //while the queue is not empty , we keep decreasing the inDegrees of the nodes in queue
        //if(num(InDegrees[of all nodes]==0, then there's a cycle ))
        vector<vector<int>> adjList(numCourses);
        vector<int>inDegree(numCourses, 0);
        queue<int>q;
        for(auto pre: prerequisites)
        {
            int a =pre[0];
            int b=pre[1];
            adjList[b].push_back(a);
            inDegree[a]++;
        }
        
        for(int i=0;i<numCourses;i++)
        {
            if(inDegree[i]==0)
                q.push(i);        
        }
        vector<int> ans;
        while(!q.empty())
        {
            int top=q.front();
            q.pop();
            ans.push_back(top);
            for(auto v :adjList[top])
            {
                if(--inDegree[v]==0)
                    q.push(v);
            }
        }
        return (ans.size()==numCourses)? ans: vector<int>{};
    }
};
