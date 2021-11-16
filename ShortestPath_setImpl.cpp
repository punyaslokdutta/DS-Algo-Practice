#include <bits/stdc++.h>
#define inf 100000000
using namespace std;
int n, e,t, m;
vector<pair<int, int> >v[1000];
 
vector<int> shortestpath(int source)
{
	set<pair<int, int> >se;
	vector<int> dist(n+1, inf);
	se.insert(make_pair(0, source));
	dist[source]=0;
	while(!se.empty())
	{
		pair<int, int> temp=*(se.begin());
		se.erase(se.begin());//pop
		int u=temp.second;
		int i;
		for(i=0;i<v[u].size();i++)
		{
			int nextnode=v[u][i].first;
			int weight=v[u][i].second;
			if(dist[nextnode]>dist[u]+weight)
			{
				if(dist[nextnode]!=inf)
				{
					se.erase(make_pair(dist[nextnode], nextnode));
				}
 
				dist[nextnode]=weight+dist[u];
				se.insert(make_pair(dist[nextnode], nextnode));
			}
		}
	}
	return dist;
 
}
int main()
{
	
	cin>>n;
	cin>>e;
	cin>>t;
	cin>>m;
	int i;
 
	for(i=1;i<=m;i++)
	{
		int x, y, w;
		cin>>x;
		cin>>y;
		cin>>w;
		v[x].push_back(make_pair(y, w));
	}
	int count=0;
	for(i=1;i<=n;i++)
	{
		vector<int> dist=shortestpath(i);
		if(dist[e]<=t)
		{
			count++;
		}
	}
	printf("%d\n", count);
 
 
	return 0;
}
 
 
 
