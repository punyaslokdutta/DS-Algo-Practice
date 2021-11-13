class Solution {
    string text1, text2;
    map <pair<int, int>, int> answer;
        
public:
    //O() M, N . The number of substrings are 2^M, 2^N. 
    //recursive approach 
    int my_LCS(int len1, int len2) // len1, len2 to take into account the indexes
    {
        if(len1==0 || len2==0)
        {
            return 0;
        }
        pair<int, int> my_state{len1, len2};
        auto it =answer.find(my_state);
            if(it!=answer.end())
            {
              return it->second;
            }
        if(text1[len1-1]==text2[len2-1])
        {
            return answer[my_state]=1+ my_LCS(len1-1, len2-1);
        }
        
        return answer[my_state]=max(my_LCS(len1-1, len2), my_LCS(len1, len2-1)); // if the end strings didn't match 
    }
    int longestCommonSubsequence(string _text1, string _text2) {
        text1=_text1;
        text2=_text2;
        return my_LCS(text1.length(), text2.length());
        
        
    }
};



// abcdefgh  -> (1 removal from here )
// afdcdefsdgh ->(3 removals from here )

//abmnopqrstuv
//mnoabmnoprst
//acdefgh


//MNO
