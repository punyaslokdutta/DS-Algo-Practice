//Iterative
class Solution{
    public:
    vector<int> inorderTraversal(TreeNode* root)
    {
        vector<int> res;
        stack<TreeNode*> st;
        TreeNode* curr=root;
        while(curr!=NULL || !st.empty())
        {
            while(curr!=NULL)
            {
                st.push(curr);
                curr=curr->left;
            }
            curr=st.top();
            st.pop();
            res.push_back(curr->val);
            curr=curr->right;
        }
        return res;
    }
};



//Recursive
class Solution {
public:
    vector<int> inorderTraversal(TreeNode* root) {
        vector<int> res;
        inorder(root, res);
        return res;
    }
    
    void inorder(TreeNode* root, vector<int> &res)
    {
        if(root==NULL)
            return;
        inorder(root->left, res);
        res.push_back(root->val);
        inorder(root->right, res);
    }
};
