//FLOYD WARSAHLL TO FIND THE all-pairs shortest path algorithm
class Solution {
public:
    int findTheCity(int n, vector<vector<int>>& edges, int distanceThreshold) {
        int INF= 1e7;
        vector<vector<int>> dist(n, vector<int>(n, INF));
        for(auto e: edges)
        {
            dist[e[0]][e[1]]=e[2];
            dist[e[1]][e[0]]=e[2];
        }
        for(int i=0;i<n;i++)
        {
            dist[i][i]= 0;
        }
        
        for(int k=0;k<n;k++)
        {
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                    dist[i][j]= min(dist[i][j], dist[i][k]+ dist[k][j]);
                }
            }  
        }
        int minNeighbours=1e7;
        int ans=0;
        for(int l=0;l<n;l++)
        {
            int neighbours=0;
            for(int m=0;m<n;m++)
            {
                if(dist[l][m]<=distanceThreshold)
                {
                    neighbours++;
                }
            }
            if(neighbours<=minNeighbours)
            {
                minNeighbours=neighbours;
                ans=l;
            }
        }
        return ans;
    }
};
