class Solution {
public:
    int largestRectangleArea(vector<int>& heights) {
        int ans=INT_MIN;
        int n=heights.size();
        vector<int>next(n), prev(n);
        stack<int> st;
        for(int i=n-1;i>=0;i--)
        {
            while(!st.empty() && heights[st.top()]>=heights[i])
                st.pop();
            if(st.empty())
                next[i]=n;
            else
                next[i]=st.top();
            st.push(i);
        }
        
        
        while(!st.empty())
        {
            st.pop();
        }
        
         for(int i=0;i<n;i++)
        {
            while(!st.empty() && heights[st.top()]>=heights[i])
                st.pop();
            if(st.empty())
                prev[i]=-1;
            else
                prev[i]=st.top();
            st.push(i);
        }
        
        for(int i=0;i<n;i++)
        {
            ans= max(ans, (next[i]-prev[i]-1)*(heights[i]));
        }
        
        return ans;
    }
};
