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
    
    bool hasPathSum(TreeNode* root, int targetSum) {
        if(root==NULL)
            return false;
        targetSum=targetSum-root->val;
        if(targetSum==0 && !root->left && !root->right)
            return true;
        return (root->left && hasPathSum(root->left, targetSum)) || (root->right && hasPathSum(root->right, targetSum));
        
        
    }
};



// Given the root of a binary tree and an integer targetSum,
// return true if the tree has a root-to-leaf 
// path such that adding up all the values along the path equals targetSum.

// A leaf is a node with no children.
