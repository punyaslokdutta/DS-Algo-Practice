class Solution {
public:
    bool res=false;
    bool dfs(vector<vector<char>>& board,int i,  int j , int index,string word)
    {
        if(res)
            return true;
        if(index==word.size())
        {
            res= true;
            return res;
        }
        // if(word[index] != board[i][j])
        //     return false;
        if(i>=0 && j>=0 && i<board.size() && j<board[0].size() && word[index]==board[i][j])
        {
        board[i][j]='2';
        dfs(board, i-1, j , index+1, word);
        dfs(board,i+1, j,  index+1, word);
        dfs(board,i,j-1, index+1, word);
        dfs(board,i, j+1, index+1, word);
        board[i][j]=word[index];
        }
        return res;
    }
    bool exist(vector<vector<char>>& board, string word) {
        int n= board.size();
        int m = board[0].size();
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(word[0]==board[i][j])
                {
                    dfs(board , i, j , 0 , word);
                }
            }
        }
        return res;
    }
};
