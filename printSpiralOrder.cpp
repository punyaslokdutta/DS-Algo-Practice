class Solution {
public:
    vector<int> spiralOrder(vector<vector<int>>& matrix) {
        vector<int> res;
        int m = matrix.size(), n = matrix[0].size();
        vector<vector<int>> dirs={{0,1}, {1,0}, {0,-1}, {-1,0}};
        vector<vector<bool>> visited(m, vector<bool>(n,false));
        
        queue<pair<int, int>> q;
        q.push({0,0});
        int dir = 0; // start with the first element in dirs array
        while(!q.empty()){
            auto [i,j] = q.front();
            q.pop();
            visited[i][j]=true;
            res.push_back(matrix[i][j]);
            for(int k=0; k<4; k++){
                int p = (k+dir)%4; //Calculate new direction
                auto ti = i+dirs[p][0], tj = j+dirs[p][1];
                if(ti>=0 && ti<m && tj>=0 && tj<n && !visited[ti][tj]){
                    q.push({ti,tj});
                    dir = p; //retain new direction for next element
                    break;
                }
            }
        }
        return res;
    }
};


//modified bfs 
