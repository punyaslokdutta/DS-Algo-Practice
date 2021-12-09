


class Solution {
public:
    // NUMBER OF DISCONNECTED COMPONENTS IN A GRAPH
    //vector<vector<char>> grid;
    void dfs( vector<vector<char>>& grid, int i, int j)
    {
        if(i < 0 || i >= grid.size() || j < 0 || j >= grid[0].size())
            return;
        
        if(grid[i][j]=='2' || grid[i][j]=='0')
            return;
        grid[i][j]='2' ;
        //visited
        dfs(grid, i+1, j);
        dfs(grid, i-1, j);
        dfs(grid, i, j-1);
        dfs(grid, i, j+1);   
    }
    int numIslands(vector<vector<char>>& grid) {
        int i, j;
        int islands=0;
        for (i=0;i<grid.size();i++)
        {
            for(j=0;j<grid[0].size();j++)
            {
                if(grid[i][j]=='1')
                {
                    dfs(grid, i, j);
                    islands++;
                }
                
            }
        }
        return islands;       
    }
};









//SPOJ QUESTION


// #include <bits/stdc++.h>
// #define ll long long 
// using namespace std;
// int island[300][300];
// int n, m ;
// ll counts=0;
// ll islandss=0;
// int mark[300][300];
// bool valid(int x, int y)
// {
// 	if(x<0 || n<=x || y<0 || m<=y)
// 	{
// 		return false;
// 	}
// 	return true;
// }
// void dfs(int i, int j)
// {
// if(mark[i][j]==1)
// {
// 	return;
// }
// mark[i][j]=1;
// counts++;
 
// if(valid(i+1, j) && island[i+1][j]==1)
// {
// 	dfs(i+1, j);
// }
// if(valid(i, j-1) && island[i][j-1]==1)
// {
// 	dfs(i, j-1);
// }
// if(valid(i-1, j) && island[i-1][j]==1)
// {
// 	dfs(i-1,j);
// }
// if(valid(i,j+1) && island[i][j+1])
// {
// 	dfs(i, j+1);
// }
 
// }
// int main()
// {
	
// 	scanf("%d", &n);
// 	scanf("%d", &m);
// 	while(n!=0 && m!=0)
// 	{
// 		ll i, j;
		
// 		islandss=0;
// 		memset(mark, 0, sizeof(mark));
// 		for(i=0;i<n;i++)
// 		{
// 			for(j=0;j<m;j++)
// 			{
// 				scanf("%d", &island[i][j]);
// 			}
// 		}
// 		ll ans[100009];
// 		memset(ans, 0, sizeof(ans));
// 		for(i=0;i<n;i++)
// 		{
// 			for(j=0;j<m;j++)
// 			{
 
// 				if(island[i][j]==1)
// 				{counts=0;
// 					dfs(i, j );
// 					if(counts!=0)
// 					{
// 						islandss++;
// 					ans[counts]++; //frequency of the island with same size
// 				}
// 				}
// 			}
// 		}
// 		printf("%lld\n", islandss);
// 		for(i=0;i<100009;i++)
// 		{
// 			if(ans[i]!=0)
// 			{
// 				printf("%lld %lld\n", i, ans[i]);
// 			}
// 		}
// scanf("%d", &n);
// 	scanf("%d", &m);
 
// 	}
 
// 	return 0;
// } 





// Input
// The input contains several test cases, each one corresponding to a different satellite image. 
// The first line of each case contains two integers that indicate the number of rows (N) and columns (M) in the image (1 <= N, M <= 250).
// Then N lines follows with M integers each, containing the information of the image.

// The end of input is indicated by a test case with N = M = 0. This case should not be processed.

// Output
// For each image, output the number of slicks in the sea. 
// Additionally, output the size of each slick in ascending order and the number of slicks of that size.

// Example
// Input:
// 10 10
// 1 1 1 1 1 1 1 1 1 1
// 1 1 1 1 0 0 0 0 0 0
// 1 1 1 0 0 0 0 1 1 1
// 1 1 0 0 1 0 0 1 1 1
// 1 0 1 0 0 1 1 0 0 0
// 0 0 0 0 0 0 0 0 0 0
// 0 0 0 0 0 0 0 0 0 0
// 1 1 1 1 1 1 1 1 1 1
// 0 0 0 0 0 0 0 0 0 0
// 1 1 1 1 1 1 1 1 1 1
// 0 0

// Output:
// 7
// 1 2
// 2 1
// 6 1
// 10 2
// 20 1
