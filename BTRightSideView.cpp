/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */

// Do a level order traversal by having
class Solution {
public:
    vector<int> rightSideView(TreeNode* root) {
        if(root==NULL)
            return {};
        vector<int> ans;
        queue<TreeNode*> q;
        q.push(root);
        while(!q.empty())
        {
            int size=q.size(); // this size is helping in finding the number of nodes at each level
            for(int i=0;i<size;i++)
            {
                TreeNode* front = q.front();
                q.pop();
                if(i==size-1)
                {
                    ans.push_back(front->val);
                }
                if(front->left)
                    q.push(front->left);
                if(front->right)
                    q.push(front->right);
            }
        }
        
        
        return ans;
        
    }
};
