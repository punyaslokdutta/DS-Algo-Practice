/*
// Definition for a Node.
class Node {
public:
    int val;
    vector<Node*> children;

    Node() {}

    Node(int _val) {
        val = _val;
    }

    Node(int _val, vector<Node*> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
public:
    vector<vector<int>> levelOrder(Node* root) {
        if(root==NULL)
            return {};
        queue<Node*> q;
        q.push(root);
        vector<vector<int>> ans;
        while(!q.empty())
        {
           int size=q.size();
           int i, j;
           vector<int>elemsInSameLevel;
           for(i=0;i<size;i++)
           {
              Node* front=q.front();
              q.pop();
              elemsInSameLevel.push_back(front->val);
              for(j=0;j<front->children.size();j++)
              {
                  if((front->children)[j]!=NULL) 
                      q.push((front->children)[j]);
              }  
           }
            
           ans.push_back(elemsInSameLevel)  ;
        }
        
        return ans;
        
        
    }
};
