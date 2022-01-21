
//The cost of one cut is the length of the stick to be cut, the total cost is the sum of costs of all cuts.
//When you cut a stick, it will be split into two smaller sticks (i.e. the sum of their lengths is the length of the stick before the cut).
//Return the minimum total cost of the cuts.

// [3, 5, 6, 7, 8, ] ->{order of cuts to get the minCost}
class Solution {
public:
    
    
    int mem[102][102];
    int solve(vector<int>& cuts, int i, int j)
    {
        if(j-i<=1)
            return 0;
        if(mem[i][j]!=-1)
            return mem[i][j];
        int minAns=INT_MAX;
        for(int k=i+1; k<j;k++)
        {
            minAns= min(minAns, cuts[j]- cuts[i] + solve(cuts,i, k)+ solve(cuts, k, j));
            mem[i][j]= minAns;
        }
        return mem[i][j]=minAns;
    }
   
    int minCost(int n, vector<int>& cuts) {
        //num=n;
        cuts.push_back(0);
        cuts.push_back(n);
        sort(cuts.begin(), cuts.end());
        memset(mem, -1, sizeof(mem));
        int ans= solve(cuts,0, cuts.size()-1);
    
    return ans;
    }
};
