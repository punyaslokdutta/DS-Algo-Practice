//Binary Tree Maximum Path Sum


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
    int ans = INT_MIN;
    int dfs(TreeNode *cur){
        if(!cur)
            return 0;
        int l = dfs(cur->left);
        int r = dfs(cur->right);
        ans = max(ans, l + r + cur->val);
        return max(0, max(l, r) + cur->val);
    }
    int maxPathSum(TreeNode* root) {
        dfs(root);
        return ans;
    }
};
