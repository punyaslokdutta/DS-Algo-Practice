#include<bits/stdc++.h>
#define ll long long 
using namespace std;
 
int main()
{
    ll t;
    cin>>t;
    
        ll i;
    while(t--)
    {ll n;
        cin>>n;
        //printf("%lld\n", ans[n]);
        ll res=n;
        for(i=2;i<=sqrt(n);i++)
        {
            if(n%i==0)
            {
                while(n%i==0)
                {
                    n=n/i;
                }
                res=res-res/i;
            }
 
            
        }
        
        if(n!=1)
        {
            res=res-res/n;
        }
        printf("%lld\n", res);
 
    }
 
    return 0;
} 
