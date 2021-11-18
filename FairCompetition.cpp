// A FAIR COMPETITION
// TIME COMPLEXITY :- O(N + M)
// SPACE COMPLEXITY:- O(N)
 
#include<bits/stdc++.h>
using namespace std;
 
#define endl "\n"
#define FIO ios_base::sync_with_stdio(false);cin.tie(NULL);cout.tie(NULL);
#define ll long long
#define vi vector<ll>
#define pb push_back
#define F first
#define S second
#define all(v) (v).begin(),(v).end()
#define pii pair<ll,ll>
#define vii vector<pii>
#define calc_fact(n) tgamma(n+1)
#define inf LONG_LONG_MAX
#define MOD 1000000007
#define mod 998244353
 
// perform the depth first search traversal
// get the size of the connected component
void dfs(ll v,vector<bool>& vis,vi adj[],ll& sz)
{
	sz++;
	vis[v] = true;
 
	for(ll u:adj[v])
	{
		if(!vis[u])
		{
			dfs(u,vis,adj,sz);
		}
	}
}
 
signed main()
{
	FIO;
 
	ll t;
	cin>>t;
	while(t--)
	{
		ll n,m,a,b,ans=0;
		cin>>n>>m;
		vi adj[n+1];
		vector<bool> vis(n+1,false);
 
		while(m--)
		{
			cin>>a>>b;
			adj[a].pb(b);
			adj[b].pb(a);
		}
		for(ll i=1;i<=n;i++)
		{
			ll sz = 0;
			if(!vis[i])
			{
				// get the number of friends for the current friend circle
				dfs(i,vis,adj,sz);
 
				// add the answer if one person is choosen from the current friend circle
				ans+=(sz*(n-sz));
			}
		}
 
		cout<<ans<<endl;
	}
}




// In competition,  participants are competing against each other for the top two spots. There are  friendly relations between participants.
// In each friendship relation, you will be given two integers  and , indicating  and  are friends.

// Note

// If A and B are friends, B and C are friends, then A, B, C will have the same friend circle.
// Two combinations are considered different if either first or second ranker is different.
// The same friendship relation can occur multiple times in input, however,  will never be equal to .
// Now, the jury has to decide the winners for the top two spots but he does not want to select both participants from the same friend circle so the competition seems fairer. Find the number of ways in which he can do so.

// Input format

// The first line contains  denoting the number of test cases. 
// The first line of each test case contains two space-separated integers  and  denoting the number of participants and the number of friendly relations.
// Next  lines of each test case contain two integers  and  indicating a friendly relation between  and .
// Output format

// For each test case, print a single line denoting the number of ways in which the jury can choose the top two participants.
// Sum of  over all test cases does not exceed 200000 and  will not exceed 500000
