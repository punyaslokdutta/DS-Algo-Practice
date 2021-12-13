
//TOPOLOGICAL SORT TO FIND CYCLE
//(a, b)-> To complete A , you need to complete B. 
//B--> A , cause B is a depencency of A.

class Solution {
public:
    bool canFinish(int numCourses, vector<vector<int>>& prerequisites) {
        
        vector<int> inDegree(numCourses, 0);
        vector<vector<int>> adjList(numCourses);
        queue<int>q;
        //BUILD THE INDEGREE MAP TO KNOW WHICH NODES ARE NOT DEPENDENT OF OTHERS
        for(int i=0;i<prerequisites.size();i++)
        {
            int a=prerequisites[i][0];
            int b=prerequisites[i][1];
            adjList[b].push_back(a);
            inDegree[a]++;
        }
        
        //INDEGREE==0 NODES IS NOT A DEPENDENCY ON ANY OTHER NODE.
        for(int i=0;i<numCourses;i++)
        {
            if(inDegree[i]==0)
            {
                q.push(i);
            }
        }
        
        int count=0;
        //IF NO NODES WITH INDEGREE 0, THEN THERE WILL BE A CYCLE
        if(q.empty()) 
            return false; // No node with indegree of 0
        
        while(!q.empty())
        {
           int top=q.front(); 
            q.pop();
            count++;
              for(int j=0;j<adjList[top].size();j++)
              {
                  inDegree[adjList[top][j]]--;
                  if(inDegree[adjList[top][j]]==0)
                  {
                      q.push(adjList[top][j]);
                  }
              }   
        }
        return (count==numCourses)? true: false;        
    }
};

//LEARN TO DEBUG WITH SMALL TEST CASES
//FOR TETSING A FUNCTION TOO.








//(a, b)-> To complete A , you need to complete B. 
//B--> A , cause B is a depencency of A.

// class Solution {
// public:
//     bool canFinish(int numCourses, vector<vector<int>>& prerequisites) {
        
//         vector<int> inDegree(numCourses, 0);
//         vector<vector<int>> adjList(numCourses);
//         queue<int>q;
//         //BUILD THE INDEGREE MAP TO KNOW WHICH NODES ARE NOT DEPENDENT OF OTHERS
//         for(int i=0;i<prerequisites.size();i++)
//         {
//             int a=prerequisites[i][0];
//             int b=prerequisites[i][1];
//             adjList[b].push_back(a);
//             inDegree[a]++;
//         }
        
//         //INDEGREE==0 NODES IS NOT A DEPENDENCY ON ANY OTHER NODE.
//         for(int i=0;i<numCourses;i++)
//         {
//             if(inDegree[i]==0)
//             {
//                 q.push(i);
//             }
//         }
        
//         int count=0;
//         //IF NO NODES WITH INDEGREE 0, THEN THERE WILL BE A CYCLE
//         if(q.empty()) 
//             return false; // No node with indegree of 0
        
//         while(!q.empty())
//         {
//            int top=q.front(); 
//             q.pop();
//             count++;
//               for(auto v: adjList[top])
//               {
//                   if(--inDegree[v]==0)
//                   {
//                       q.push(v);
//                   }
//               }   
//         }
//         return (count==numCourses)? true: false;        
//     }
// };

// //LEARN TO DEBUG WITH SMALL TEST CASES
// //FOR TETSING A FUNCTION TOO.
