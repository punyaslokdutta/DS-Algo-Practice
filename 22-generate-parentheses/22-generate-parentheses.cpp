class Solution {
public:
    vector<string> ans;
    void print( int n, int numLeft, int numRight, string &s)
    {
        if(numLeft + numRight == 2*n)
        {
            ans.push_back(s);
            return;
        }
        if(numLeft<n)
        {
            s.push_back('(');
            print(n, numLeft+1, numRight, s);
            s.pop_back();
        }
        if(numRight<numLeft)
        {
            s.push_back(')');
            print(n, numLeft, numRight+1, s);
            s.pop_back();
        }
        return;
    }
    vector<string> generateParenthesis(int n) {
        string s="";
        print(n, 0, 0, s);
        
        return ans;
        
    }
};