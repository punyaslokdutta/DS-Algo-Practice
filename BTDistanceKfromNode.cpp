/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    unordered_map<TreeNode*, TreeNode*> parentMap;
    void levelOrder(TreeNode* root)
    {
        if(root==NULL)
            return;
        queue<TreeNode*> q;
        q.push(root);
        while(!q.empty())
        {
            TreeNode* front=q.front();
            q.pop();
            if(front->left)
            {
                q.push(front->left);
                parentMap[front->left]=front;
            }
            if(front->right)
            {
                q.push(front->right);
                parentMap[front->right]=front;  //LEVEL ORDER TRAVERSAL
            }                                   //TO CREATE PARENT MAP
        }
        
    }
    
    vector<int> distanceK(TreeNode* root, TreeNode* target, int k) {
        levelOrder(root);
        parentMap[root]=NULL;
        queue<TreeNode*>q;
        unordered_set<TreeNode*>visited;
        vector<int>ans;
        if(target)
        {
            q.push(target);
            visited.insert(target);
        }
            
        while(!q.empty() && k!=0)
        {
            int size=q.size();
            k--;
            for(int i=0;i<size;i++)
            {
               TreeNode* front=q.front();
               q.pop();
               if(front->left && visited.find(front->left)==visited.end())
               {
                   q.push(front->left);
                   visited.insert(front->left);
               }
               if(front->right && visited.find(front->right)==visited.end())
               {
                   q.push(front->right);
                   visited.insert(front->right);
               }
               if(parentMap[front] && visited.find(parentMap[front])==visited.end())
               {
                   q.push(parentMap[front]);
                   visited.insert(parentMap[front]);
               }
                
            }    
        }
        
        while(!q.empty())
        {
            TreeNode* front=q.front();
            ans.push_back(front->val);
            q.pop();
        }
        
        return ans;
        
        
        
        
    }
};
