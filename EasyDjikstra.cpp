#include<bits/stdc++.h>
#define ll long long 
#define inf 1000000000000000000
using namespace std;
int n;
int k;
 
 
void dj(vector<pair<int, int> >v[], int source, int dest)
{
	priority_queue< pair<int,int> , vector<pair <int, int > >,greater<pair<int,int> > > pq;
	vector<ll> dist(n+1, inf);
	dist[source]=0;
	pq.push(make_pair(0, source));
	map<int, int>mark;
	while(!pq.empty())
	{
		pair<int, int>temp=pq.top();
		int current=temp.second;
		pq.pop();//pop
		/*if(current==dest)
		{
			break;
		}
		if(mark[current])
		{
			continue;
		}*/
		
		//mark[current]=1;
		int i;
		for(i=0;i<v[current].size();i++)
		{
			int nextnode=v[current][i].first;
			int weight=v[current][i].second;
			if(dist[nextnode]>dist[current]+weight)
			{
				dist[nextnode]=dist[current]+weight;
				pq.push(make_pair(dist[nextnode], nextnode));
				
			}
			
 
		}
 
	}
	int i;
/*for(i=1;i<n;i++)
{
	printf("%lld\n", dist[i]);
}*/
	if(dist[dest]!=inf)
	{
		printf("%lld\n", dist[dest]);
		
	}
	else
	{
		printf("NO\n");
	}
}
int main()
{
	std::ios::sync_with_stdio(false);
	int t;
	scanf("%d", &t);
	while(t--)
	{
		vector<pair<int, int> >v[10000];
		scanf("%d", &n);
		
		scanf("%d", &k);
		int i;
		for(i=1;i<=k;i++)
		{
			int x, y, w;
			scanf("%d", &x);
			scanf("%d", &y);
			scanf("%d", &w);
			v[x].push_back(make_pair(y, w));
 
		}
		int a, b;
		scanf("%d", &a);
		scanf("%d", &b);
		dj(v,a, b);
 
	}
	return 0;
} 
