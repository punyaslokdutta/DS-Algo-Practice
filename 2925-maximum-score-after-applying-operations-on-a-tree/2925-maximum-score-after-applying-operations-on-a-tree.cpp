class Solution {
public:
    // time/space: O(n)/O(n)
    long long maximumScoreAfterOperations(vector<vector<int>>& edges, vector<int>& values) {
        int n = values.size();
        // build the graph (tree)
        vector<vector<int>> graph(n);
        for (auto edge : edges) {
            graph[edge[0]].push_back(edge[1]);
            graph[edge[1]].push_back(edge[0]);    
        }
        
        vector<vector<long long>> dp(n, vector<long long>(2, -1LL));
        return helper(graph, values, dp, 0, -1, 0);
    }
private:
    long long helper(vector<vector<int>>& graph, vector<int>& values, vector<vector<long long>>& dp, int curr, int prev, int isHealthy) {
        // terminate
        if (dp[curr][isHealthy] != -1LL) return dp[curr][isHealthy];
        if ((graph[curr].size() == 1) && (graph[curr][0] == prev)) {
            // the leaf node must be healthy
            if (isHealthy == 0) return dp[curr][isHealthy] = 0LL;
            return dp[curr][isHealthy] = values[curr];
        }
        
        // enumerate
        long long take = values[curr];
        long long skip = 0;
        for (auto next : graph[curr]) {
            if (next == prev) continue;
            take += helper(graph, values, dp, next, curr, isHealthy);
            skip += helper(graph, values, dp, next, curr, 1);
        }
        return dp[curr][isHealthy] = max(take, skip); 
    }
};