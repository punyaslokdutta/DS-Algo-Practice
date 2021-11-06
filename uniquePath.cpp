class Solution {
public:
    long long fact(int n){
        if(n==1 || n==0) return 1;
        return fact(n-1)*n;
    }
    int uniquePaths(int m, int n) {
        
        int x=min(m,n);
        int y=max(m,n);
        y=m+n-2;
        int t=x-1;
        long long res=1;
        while(t--){
            res=res*y;
            y--;
        }
        long long z=fact(x-1);
        
        return res/z;
    }
};
