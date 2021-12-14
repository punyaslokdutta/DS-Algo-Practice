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
    //WE NEED TO GET ALL THE PATHS IN ANS VECTOR
    //MAKE SUBANS, ANS AND PASS TO THE RECURSIVE FUNCTION 
    //CAUSE THEY WILL BE USED WHILE VISTING THE CHILDREN NODES
    
    
    
    
    void getAllPaths(TreeNode* root, vector<int> subAns,vector<vector<int>> &ans, int targetSum)
    { 
        //THIS FUNCTION WILL KEEP UPDATIN ANS AND SUBANS
        if(root==NULL)
            return;
        subAns.push_back(root->val);
        targetSum-=root->val;
        if(root->left==NULL && root->right==NULL && (targetSum==0))
        {
           
            ans.push_back(subAns);
            return;
        }
       // subAns.push_back(root->val);
        getAllPaths(root->left, subAns, ans, targetSum);
        getAllPaths(root->right, subAns, ans, targetSum);
        
    }
    vector<vector<int>> pathSum(TreeNode* root, int targetSum) {
        
        vector<vector<int>> ans;
        vector<int>subAns;
        getAllPaths(root,subAns, ans, targetSum);
        return ans;
       
    }
};
