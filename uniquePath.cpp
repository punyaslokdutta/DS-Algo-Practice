class Solution {
public:
    
    long long fact(int x)
    {
        if(x==1 || x==0)
            return 1;
        return x* fact(x-1);
    }
    
    int uniquePaths(int m, int n) { 
        //IF WE TAKE MAX HERE , THE LOOP TIMINGS WILL INCREASE BOTH FOR WHILE 
        // AND FACTORIAL RECURSION.
        int x=min(m, n); 
        int y=m+n-2;
        int t=x-1;
        long long res=1;

        while(t--)
        {
            res=res*y;
            y--;
        }
        
        long long l=fact(x-1);
        
        return res/l;
    }
   
};
