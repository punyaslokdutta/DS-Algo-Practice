#include <bits/stdc++.h>
#define ll long long 
using namespace std;
ll a[100000];
ll dp[100009];
ll n;
ll solve(ll i)
{
	if(i>=n)
	{
		return 0;
	}
	else if(dp[i]!=-1)
	{
		return dp[i];
	}
	dp[i]=max(a[i]+solve(i+2), solve(i+1));
	return dp[i];
 
}
int main()
{
	ll t;
	ll z;
	cin>>t;
	for(z=1;z<=t;z++)
	{
	ll i;
	scanf("%lld", &n);
	
	for(i=0;i<n;i++)
	{
		scanf("%lld", &a[i]);
	}
	memset(dp, -1, sizeof(dp));
	ll ans=solve(0);
	printf("Case %lld: %lld\n",z, ans );
}
 
	return 0;
} 




// Once upon time there was a cute princess called Farida living in a castle with her father, mother and uncle. 
// On the way to the castle there lived many monsters. Each one of them had some gold coins. Although they are monsters they will not hurt. 
// Instead they will give you the gold coins, but if and only if you didn't 
// take any coins from the monster directly before the current one.
// To marry princess Farida you have to pass all the monsters and collect as many coins as possible.
// Given the number of gold coins each monster has, calculate the maximum number of coins you can collect on your way to the castle.

// Input
// The first line of input contains the number of test cases. 
// Each test case starts with a number N, the number of monsters, 0 <= N <= 10^4. The next line will have N numbers, number of coins each monster has, 0 <= The number of coins with each monster <= 10^9. Monsters described in the order they are encountered on the way to the castle.

// Output
// For each test case print “Case C: X” without quotes. C is the case number, starting with 1. X is the maximum number of coins you can collect.

// Example
// Input:
// 2
// 5
// 1 2 3 4 5
// 1
// 10

// Output:
// Case 1: 9
// Case 2: 10
