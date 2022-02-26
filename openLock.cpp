
// STRING + BFS + DEADEND COMBINATION
// You have a lock in front of you with 4 circular wheels. Each wheel has 10 slots: '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'.
// The wheels can rotate freely and wrap around: for example we can turn '9' to be '0', or '0' to be '9'. Each move consists of turning one wheel one slot.
// The lock initially starts at '0000', a string representing the state of the 4 wheels.
// You are given a list of deadends dead ends, meaning if the lock displays any of these codes, the wheels of the lock will stop turning and you will be unable to open it.
// Given a target representing the value of the wheels that will unlock the lock, return the minimum total number of turns required to open the lock, or -1 if it is impossible.

class Solution {
public:
    int openLock(vector<string>& deadends, string target) {
        queue<string> q;
        q.push("0000");
        unordered_set<string> vis;
        unordered_set<string> deadEnds(deadends.begin(), deadends.end());
        if(deadEnds.find("0000")!=deadEnds.end())
            return -1;
        vis.insert("0000");
        int moves =0;
        while(!q.empty())
        {
        int size= q.size();
            while(size--)
            {
                string curr = q.front();
                q.pop();
                //vis.insert(curr);
                if(curr==target)
                    return moves;
                for(int i=0;i<4;i++)
                {
                    //up
                    string temp=curr;
                    temp[i]=(temp[i]=='9')?'0':temp[i]+1;
                    if(vis.find(temp)==vis.end() && deadEnds.find(temp)==deadEnds.end())
                    {
                        q.push(temp);
                        vis.insert(temp);
                    }
                    //down
                    temp=curr;
                    temp[i]=(temp[i]=='0')?'9':temp[i]-1;
                    if(vis.find(temp)==vis.end() && deadEnds.find(temp)==deadEnds.end())
                    {
                        q.push(temp);
                        vis.insert(temp);
                    }
                }
                //vis.insert(curr);
        }
        moves++;
        }
        
      return -1;
        
        
    }
};
