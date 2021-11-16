#include<bits/stdc++.h>
#define ll long long 
using namespace std;
ll n, k;
ll a[1009];
ll dp[1009][1009];
ll solve(ll i, ll w)
{
	if(i>n)
	{
		return w; 
	}
	if(dp[i][w]!=-1)
	{
		return dp[i][w];
	}
	if(a[i]+w<=k)
	{
		dp[i][w]=max(solve(i+2,w+a[i]), solve(i+1, w));
	}
	else
	{
		dp[i][w]= solve(i+1, w);
	}
	return dp[i][w];
}
 
 
int main()
{
	ll t;
	cin>>t;
	ll j;
	ll i;
	for(j=1;j<=t;j++)
	{
	cin>>n;
	cin>>k;
	
	
	for(i=1;i<=n;i++)
	{
		scanf("%lld", &a[i]);
	}
	memset(dp, -1, sizeof(dp));
	ll ans=solve(1, 0);
	printf("Scenario #%lld: %lld\n",j, ans);
}
 
	return 0;
} 
