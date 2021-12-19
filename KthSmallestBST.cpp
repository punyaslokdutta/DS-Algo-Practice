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
    vector<int> v;
    int kthSmallest(TreeNode* root, int k) {
        kSmallest(root, k);  
        return v[k-1]; // 1 <= k <= n <= 104
    }
    
    void kSmallest(TreeNode* root, int k)
    {
        if(!root)
            return;
        kSmallest(root->left, k);
        v.push_back(root->val);
        if(v.size()==k)
            return;
        kSmallest(root->right, k);
       // return;
    }
};
