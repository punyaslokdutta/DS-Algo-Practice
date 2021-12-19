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


class Solution {
public:
    unordered_map<TreeNode*, int> umap;
    int dfs(TreeNode* root)
    {
        if(!root)
            return 0;
        if(umap[root])
            return umap[root];
        int leftMax=0;
        int rightMax=0;
        if(root->left)
            leftMax=dfs(root->left->left) + dfs(root->left->right);
         if(root->right)
            rightMax=dfs(root->right->left)+dfs(root->right->right);
        return umap[root]=max(root->val + leftMax+ rightMax, dfs(root->left)+dfs(root->right));
        
    }
    int rob(TreeNode* root) {
        return dfs(root);  
        
    }
};
