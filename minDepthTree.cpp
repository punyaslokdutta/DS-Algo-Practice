class Solution {
public:
    int minDepth(TreeNode* root) {
        if(root==NULL)
            return 0;
        if(root->left==NULL && root->right==NULL) 
            return 1;
        if(root->left==NULL)
            return 1+minDepth(root->right);
        if(root->right==NULL)
            return 1 +minDepth(root->left);
        else
            return 1+ min(minDepth(root->left), minDepth(root->right));
        
    }
};
