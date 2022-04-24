class Solution {
public:
    vector<string> findRepeatedDnaSequences(string s) {
        
        int l =0;
        int r = 9;
        int n = s.size();
        unordered_map<string, int> ump;
        set<string> ans;
        while(l<=n-10 && r<n)
        {
            string sub(s.begin() + l , s.begin() + r+1);
            if(ump.find(sub)!=ump.end())
            {
                ump[sub]++;
            if(ump[sub] > 1)
                ans.insert(sub);
            }
            ump[sub]++;
            l++;
            r++;
        }
        vector<string> vAns;
        for(auto i:ans)
            vAns.push_back(i);
        return vAns;
        
    }
};