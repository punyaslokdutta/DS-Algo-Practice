#include <bits/stdc++.h>
#define ll long long
using namespace std;
vector<ll >v[10009];
pair<ll, ll> temp[10009];
ll mark[10009];
ll dfs(ll x)
{
	ll i;
	mark[x]=1;
	ll ans=0;
	ll secondans=0;
	for(i=0;i<v[x].size();i++)
	{
		if(mark[v[x][i]]==0)
		{
				ll xx=dfs(v[x][i]);
				if(ans<=xx)
				{
					
					secondans=max(secondans, ans);
					ans=xx;
 
				}
				else 
				{
					secondans=max(secondans, xx);
				}
 
 
		}
	}
	temp[x].first=ans;
	temp[x].second=secondans;
	return ans+1;
 
 
 
 
}
int main()
{
	ll n;
	cin>>n;
	memset(v, 0, sizeof(v));
	memset(temp, 0, sizeof(temp));
	memset(mark, 0, sizeof(mark));
	ll i;
	for(i=1;i<=n-1;i++)
	{
		ll x,y;
		cin>>x;
		cin>>y;
		v[x].push_back(y);
		v[y].push_back(x);
	}
 ll sum=dfs(1);
 ll answer=0;
/*for(i=1;i<=n;i++)
{
printf("%lld, %lld ->", temp[i].first, temp[i].second);
}*/
 
for(i=1;i<=n;i++)
{
	answer=max(answer, temp[i].first+temp[i].second);
 
}
printf("%lld\n", answer);
 
	return 0;
 
 
 
} 





// You are given an unweighted, undirected tree. 
// Write a program to output the length of the longest path (from one node to another) in that tree.
// The length of a path in this case is number of edges we traverse from source to destination.

// Input
// The first line of the input file contains one integer N --- number of nodes in the tree (0 < N <= 10000). 
// Next N-1 lines contain N-1 edges of that tree --- Each line contains a pair (u, v) means there is an edge between node u and node v (1 <= u, v <= N).

// Output
// Print the length of the longest path on one line.

// Example
// Input:
// 3
// 1 2
// 2 3

// Output:
// 2
