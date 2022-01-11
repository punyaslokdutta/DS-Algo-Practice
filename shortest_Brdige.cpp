

static int direction[5] = {-1, 0, 1, 0, -1};
static auto x = []() {
    std::ios::sync_with_stdio(false);
    std::cin.tie(0);
    return 0;
}();
class Solution {
public:
    int shortestBridge(vector<vector<int>>& grid) {
        int n = grid.size(), m = n * n, path = 0;
        queue<pair<int, int>> island;
        bool not_find = true;
        for (int r = 0; r < n && not_find; ++r) {
            for (int c = 0; c < n; ++c) {
                if (grid[r][c]) {
                    dfs(grid, island, r, c);
                    not_find = false;
                    break;
                }
            }
        }
        
        while (!island.empty()) {
            ++path;
            int qsz = island.size();
            while (qsz--) {
                auto [row, col] = island.front();
                island.pop();
                for (int k = 0; k < 4; ++k) {
                    int r = row + direction[k], c = col + direction[k + 1];
                    if ((unsigned int) r >= n || (unsigned int) c >= n || grid[r][c] == -1) {
                        continue;
                    }
                    if (grid[r][c]) {
                        return path;
                    }
                    grid[r][c] = -1;
                    island.push(pair(r, c));
                }
            }
        }
        
        return 0;
        
    }
    
    void dfs(vector<vector<int>>& grid, queue<pair<int, int>>& island, int r, int c) {
        if ((unsigned int) r >= grid.size() || (unsigned int) c >= grid.size() || grid[r][c] < 0) {
            return;
        }
        if (!grid[r][c]) {
            island.push(pair(r, c));
            return;
        }
        grid[r][c] = -1;
        dfs(grid, island, r - 1, c);
        dfs(grid, island, r + 1, c);
        dfs(grid, island, r, c - 1);
        dfs(grid, island, r, c + 1);
    }
};// class Solution {
//     vector<vector<int> > mat;
//     vector<vector<int> > vis;
//     int m,n;
//     int x[4]={-1,0,1,0};
//     int y[4]={0,1,0,-1};
//     queue<pair<int,int> > que;
// public:
//     void dfs(int i,int j){
//         vis[i][j]=1;
//         que.push({i,j});
//         for(int dir=0;dir<4;dir++){
//             int xd=i+x[dir];
//             int yd=j+y[dir];
//             if(xd>=0 && yd>=0 && xd<=m-1 && yd<=n-1){
//                 if(!vis[xd][yd] && mat[xd][yd]==1){
//                     dfs(xd,yd);
//                 }
//             }
//         }
//     }
//     int shortestBridge(vector<vector<int>>& A) {
//         m=A.size();
//         if(m==0) return 0;
//         n=A[0].size();
//         cout<<m<<" "<<n;
//         mat=A;
//         vis.resize(m,vector<int>(n,0));
//         int flag=0;
//         for(int i=0;i<m;i++){
//             for(int j=0;j<n;j++){
//                 if(mat[i][j]==1){
//                     dfs(i,j);
//                     flag=1;
//                     break;
//                 }
//             }
//             if(flag){
//                 break;
//             }
//         }
//         int l=0;
//         while(!que.empty()){
//             int len=que.size();
//             l++;
//             while(len--){
//                 pair<int,int> poi=que.front();
//                 que.pop();
//                 //vis[poi.first][poi.second]=1;
//                 for(int dir=0;dir<4;dir++){
//                     int xd=poi.first+x[dir];
//                     int yd=poi.second+y[dir];
//                     if(xd>=0 && yd>=0 && xd<=m-1 && yd<=n-1){
//                        if(!vis[xd][yd] && mat[xd][yd]==1){
//                            return l-1;
//                        }
//                        else if(!vis[xd][yd] && mat[xd][yd]==0){
//                            vis[xd][yd]=1;
//                            que.push({xd,yd});
//                        }
//                     }
//                 }
//             }
//         }
//         return -1;
//     }
// };      


// class Solution {
// public:
//     vector<pair<int, int>> c1, c2;
//     void floodFill(vector<vector<int>> &grid, int i, int j, int count)
//     {
        
//         if(i<0 || i>=grid.size() || j<0 || j>=grid.size() || grid[i][j]==0)
//             return;
//         if(count==1)
//         {
//             c1.push_back({i, j});
//             //cout<<"Pushing in C1"<<"i->"<<i<<"j->"<<j<<"\n";
//         }
//         else
//         {
//             c2.push_back({i, j});
//             //cout<<"Pushing IN c2"<<i<<j<<"\n";
//         }
//         grid[i][j]=0;
//         floodFill(grid, i+1, j, count);
//         floodFill(grid, i, j+1, count);
//         floodFill(grid, i, j-1, count);
//         floodFill(grid, i-1,j, count);
        
//     }
//     int shortestBridge(vector<vector<int>>& grid) {
        
//         int n =grid.size();
//         int m = grid[0].size();
//         int count =0;
//         for(int i=0;i<n;i++)
//         {
//             for(int j = 0;j<n;j++)
//             {
//                 if(grid[i][j]==1)
//                 {
//                     count++;
//                     if(count==1)
//                     {
//                         floodFill(grid, i, j, count);
                        
                        
//                     }
//                     else if(count==2)
//                     {
//                         floodFill(grid, i, j, count);
//                     }
//                 }
//             }
//         }
        
//        int min_dist = INT_MAX;
//         for(int i=0; i<c1.size(); i++)
//         {
//             for(int j=0; j<c2.size(); j++)
//             {
//                 int dist = abs(c1[i].first - c2[j].first) + abs(c1[i].second - c2[j].second) - 1;
//                 if(dist < min_dist)
//                     min_dist = dist;
//             }
//         }
//         return min_dist;
//     }
// };
