#include<iostream>
#include<cstring>
using namespace std;

int min(int , int , int);
int editdistance(string str1, string str2, int length1, int length2)
{
	int L[length1+1][length2+1];
	for(int i=0;i<=length1;i++)
	{
		for(int j=0;j<=length2;j++)
		{
			if(i==0)
				L[i][j] = j;//if string 1 is empty then store string 2 
			else if(j==0)
					L[i][j] = i;
			
			else if(str1[i-1] == str2[j-1])
					L[i][j] = L[i-1][j-1];
			
			else if(str1[i-1] != str2[j-1])
					L[i][j] = 1 + min(L[i-1][j], L[i][j-1], L[i-1][j-1]);//in dynamic programming we dont recompute the values but use the 
					//stored values in the table		
		}
		
	}
	return L[length1][length2];
}

int min(int a, int b, int c)
{
	return min(min(a,b),c);
}

int main()
{
	int n,m;
	string s1, s2;
	int t;
	cin>>t;
	for(int i=0;i<t;i++)
	{
	cin>>s1>>s2;
	m=s1.length();
	n=s2.length();
	
	cout<<editdistance(s1,s2,m,n)<<endl;
}
}
