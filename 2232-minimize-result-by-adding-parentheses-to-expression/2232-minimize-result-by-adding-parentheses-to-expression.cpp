class Solution {
public:
    int func(string& e,int i,int j,int p){
        int a=1;
        if(i>0) a=stoi(e.substr(0,i));
        int b=stoi(e.substr(i,p-i));
        int c=stoi(e.substr(p+1,j-p));
        int d=1;
        if(j+1<e.size()) d=stoi(e.substr(j+1,e.size()-j));
        return a*(b+c)*d;
    }
    string minimizeResult(string e) {
        int p=0;                      //will store the index of '+'
        for(p=0;p<e.size();p++){
            if(e[p]=='+') break;
        }
        int ans=INT_MAX;              // will store the minimum possible value
        string res;
        for(int i=0;i<p;i++){                         // i-> where we will add '('
            for(int j=p+1;j<e.size();j++){            // j-> where we will add ')'
                int val=func(e,i,j,p);                // try every possible way 
                if(val<ans){
                    ans=val;
                    res=e;
                    res.insert(j+1,1,')');
                    res.insert(i,1,'(');
                }
            }
        }
        return res;
    }
};