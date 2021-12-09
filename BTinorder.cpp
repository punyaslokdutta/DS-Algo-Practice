//Iterative


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

//Inorder -> {left, root, right};


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

//Inorder -> {left, root, right};
class Solution {
public:
    vector<int> answer;
    // void inorder(TreeNode * root)
    // {
    //     if(root==NULL)
    //         return;
    //     inorder(root->left);
    //     answer.push_back(root->val);
    //     inorder(root->right);
    // }
    
    vector<int> inorderTraversal(TreeNode* root) { 
       stack<TreeNode*> st;
       TreeNode* p=root;
       vector<int> ans;
        while(p!=NULL || !st.empty())
        {
            if(p!=NULL)
            {
                st.push(p);
                p=p->left;
            }
            else
            {
              p=st.top();
              st.pop();
              ans.push_back(p->val);
              p=p->right; // Take out from stack to find the last parent and move to it's right
            }
        }
        return ans;
    }
       
   
};


    
    
    
    
    
    
//Recursive
// vector<int> inorderTraversal(TreeNode* root) { 
//         inorder(root);
//         return ans;
//     }
//     void inorder(TreeNode* root )
//     {
//         if(root==NULL)
//             return;
//         inorder(root->left);
//         ans.push_back(root->val);
//         inorder(root->right);
//     }
    
    
    
    
    
    
//Recursive
// vector<int> inorderTraversal(TreeNode* root) { 
//         inorder(root);
//         return ans;
//     }
//     void inorder(TreeNode* root )
//     {
//         if(root==NULL)
//             return;
//         inorder(root->left);
//         ans.push_back(root->val);
//         inorder(root->right);
//     }


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
