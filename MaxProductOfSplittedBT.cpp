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

#define MOD 10e9+7
class Solution {
public:
    long ans=1;
    long sum=0;
    //preorder traversal to get the sum of the elements
    long max(long a, long b)
    {
        if(a>b)
            return a;
        else
            return b;
    }
    void traverse(TreeNode* root)
    {
        if(!root)
            return;
        sum+=root->val;
        traverse(root->left);
        traverse(root->right); 
    }
    int solve(TreeNode* root)
    {
        if(!root)
            return 0;
        if(root->left==NULL && root->right==NULL)
            return root->val;
        long leftSum=solve(root->left);
        long rightSum= solve(root->right);
        long subTreeSum= leftSum + rightSum + root->val;
        ans= max(ans,subTreeSum*(sum-subTreeSum));
        return subTreeSum;
    }
    int maxProduct(TreeNode* root) {
        traverse(root);
        solve(root);
        return ans%int(pow(10,9)+7);;
        
        
    }
};
