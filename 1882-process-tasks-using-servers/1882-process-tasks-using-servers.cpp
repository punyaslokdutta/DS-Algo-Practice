class Solution {
public:
    vector<int> assignTasks(vector<int>& servers, vector<int>& tasks) {
        // 2 priority queues - time, weight, index
        // busy and available
        // init available from servers {0, servers[i], i}
        // for all tasks:
        // while busy is not empty && busy[0] time is <= t || availabile is empty
        // then
        // take from busy and add to available with updated time
        // } 
        // auto [t, w, s]
        //  take from available, add to busy
        // insert s to results
        std::vector<int> res;
        std::priority_queue<std::array<int, 3>, std::vector<std::array<int, 3>>, std::greater<std::array<int, 3>>> available, busy;
        for (int i = 0; i < servers.size(); ++i) {
            available.push({0, servers[i], i});
        }
        
        for (int t = 0; t < tasks.size(); ++t) {
            
            while(!busy.empty() && (busy.top()[0] <= t || available.empty())) {
                auto [time, weight, index] = busy.top();
                busy.pop();
                // is it ready or is it not? if its ready (as in, time <= t)
                // then put 0 for time.  else, put the time
                auto actualTime = time <= t ? 0 : time;
                available.push({actualTime, weight, index});
            }
            
            auto [time, weight, server] = available.top();
            available.pop();
            
            auto newTime = std::max(time, t) + tasks[t];
            busy.push({newTime, weight, server});
            res.push_back(server);
        }
        
        return res;
    }
};