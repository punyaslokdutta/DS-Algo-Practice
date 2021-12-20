



// class Solution {
// public:
//     //INDEX DIFFERENCE BETWEEN I AND OF THE NEXT GREATER ELEMENT
//     vector<int> dailyTemperatures(vector<int>& temperatures) {
//         int n= temperatures.size();
//         vector<int> ans(n, 0);
//         stack<int> st{};
        
//         for(int i=n-1;i>=0;i--)
//         {
//             //ST.TOP()< TEMP[I] , THAT MEANS WE NEED TO FIND TO THE NEXT GREATER ELEMENT
//             //BY POPPING ELEMENTS FROM THE STACK TILL WE REACH THE NEXT GREATER.
//             while(!st.empty() && temperatures[st.top()]<= temperatures[i])
//                 st.pop();
            
//             //UPDATE THE ANS ARRAY WHEN WE REACH TO THE ELEMENT IN STACK JUST GREATER 
//             // THAN THE TEMP[INDEX]
//             if(!st.empty())
//                 ans[i]=st.top()-i;
            
//             st.push(i);
            
//         }
        
//         return ans;
        
//     }
// };



class Solution {
public:
    vector<int> dailyTemperatures(vector<int>& t) {
        // support variables
        int len = t.size(), pos = 0, s[250];
        s[pos] = len - 1;
        vector<int> res(len);
        // looping from right to left, starting from the penultimate element
        for (int i = len - 2, n; i >=0; --i) {
            n = t[i];
            // removing reducing pos as long as we find smaller elements
            while (pos >= 0 && n >= t[s[pos]]) pos--;
            // // if we still have something in the array, we update res
            if (pos > -1) res[i] = s[pos] - i;
            // updating the array
            s[++pos] = i;
        }
        return res;
    }
};


// The monotonic stack is a very useful data structure and appearing in many interview problems. The most difficult part is to know whether a problem can be solved by this data structure or not.
// We need to remember the three characters to help us think about that:
// 1. It is a “range queries in an array” problem.
// 2. The minima/maxima element or the monotonic order of elements in a range is useful to get answer of every range query.
// 3. When a element is popped from the monotonic stack, it will never be used again.
