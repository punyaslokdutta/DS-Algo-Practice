#include<bits/stdc++.h>
using namespace std;

int gcd(int a,int b)
{
   if(b==0)
       return a;
   
   return gcd(b,a%b);
}

int main()
{
   int t;
   cin >> t;
   
   while(t--)
   {
       int n,k,ans = 1;
       cin >> n >> k;
       
       if(n < k)
       {
           if((k%n) == 0)
               ans = 1;
           else
               ans = n / gcd(k,n);
           
       }
       else if(n == k)
           ans = 1;
       else
       {
           if((n%k) == 0)
               ans = (n/k);
           else
               ans = n / gcd(n,k);
       }
       
       cout << ans << "\n";
   }
   
   return 0;
  }



// Chef is throwing a party for his N friends. 
// There is a pizza store nearby and he wants to buy pizza for his friends.
// Each pizza has exactly K slices. 
// Chef's friends get sad if one gets more slices than the other.
// Also, Chef gets sad if there are some pizza slices left. More formally, suppose Chef buys P pizzas, then everyone is happy if and only if there is a way to distribute K⋅P slices between N friends.

// You need to find the minimum number of pizzas Chef has to buy to share all
// the slices among his friends so that none of his friends gets sad.
//   Note that Chef hates pizza and doesn't take any slices.


// 1≤T≤2⋅105 
// 1≤N,K≤109

